# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository. Topic- and
path-specific rules live under `.claude/rules/` — see the index at the bottom of this file.

## Project

`com.faizsiegeln:njams-messageformat` — a single-module Maven library (jar, Java 11) that defines the **wire format for communication between the nJAMS server and nJAMS clients/SDK**. It contains only the data model plus a small command layer.

**The project's scope is strictly limited to defining that format.** It holds no runtime logic, no transport code, and no behavior beyond data carriage. Functionality that belongs in the SDK or the Server does not belong here — if a change would put behavior into this project, say so and ask before proceeding. `.claude/rules/wire-contract.md` is the rule that governs everything else.

### Project Resources

- **Published JavaDoc:** https://integrationmatters.github.io/njams-messageformat/ — the latest release's API docs, and this project's only user-facing documentation
- **Repository:** https://github.com/IntegrationMatters/njams-messageformat
- **Consumers:** nJAMS SDK (locally at `../sdk-6.1-dev/`, Jira key `SDK`) and nJAMS Server (Jira key `SER`)

## No Unsupported Assumptions

**Every decision must rest on verified evidence, not inference.** Before asserting a fact about this codebase, a consumer's behavior, or how a field is serialized, verify it by reading the actual source, running the actual command, or checking the actual output — never assume it from general training-data familiarity or what "should" be true.

This matters more here than in most projects: the serialization that gives these classes meaning happens in *other* repositories, so a guess about how a field is mapped cannot be checked against anything in this one.

**When genuinely uncertain, stop and ask the user** rather than deciding unilaterally — whether the uncertainty is a technical fact, a scope judgment, or a choice between multiple reasonable interpretations.

## Build & test

```bash
mvn clean test                              # compile + run all tests
mvn test -Dtest=InstructionMapperTest       # single test class
mvn test -Dtest=InstructionMapperTest#methodName
mvn generate-sources javadoc:javadoc        # JavaDoc -> target/reports/apidocs
mvn clean verify                            # jar + sources jar (the sources jar is bound to 'verify', not 'package')
```

Never run `mvn install` for intermediate checks.

`src/main/resources/msg.version` is **filtered**, and since MSG-31 every value resolves from the build itself with no command-line properties: timestamp, year and build id come from `build-helper-maven-plugin`, branch and commit from `git-commit-id-maven-plugin` (falling back to `unknown` where there is no `.git`, e.g. a source-archive build).

Nothing in *this* repository reads the file, but the SDK does, at runtime: `NjamsMetadata` loads it off the classpath and puts every key it contains into the version map the client announces to the nJAMS server.

This file is **build information, not part of the message format.** It carries no payload semantics, sits outside `wire-contract.md`'s change gate, and changing it needs no `SER`/`SDK` counterpart ticket. The SDK does read the keys by name, though, so renaming one still changes what the server is told.

## Architecture

Everything lives under `com.faizsiegeln.njams.messageformat.v4` (the `v4` segment is the message-format major version, not a package-layout artifact; `MessageVersion.V4` is stamped into every `LogMessage`).

Four message families, each a package:

| Package | Direction | Purpose |
|---|---|---|
| `logmessage` | client → server | Runtime execution data: a `LogMessage` (one job) holding `Activity` list, `Predecessor` links, `PluginDataItem`s |
| `projectmessage` | client → server | Deployment/model data: `ProjectMessage` with `ProcessModel`s, `Activity`s, `Transition`s, `Extract`/`ExtractRule`s, `Tracepoint`s |
| `tracemessage` | server → client | Which activities to trace: `TraceMessage` → `ProcessModel` → `Activity` → `Tracepoint` |
| `command` | both | `Instruction` (request/response envelope) carrying a `Command` |

`common` holds what the message families share: `CommonMessage` — the base class of `LogMessage`, `ProjectMessage` **and** `TraceMessage`, carrying client/sdk/runtime version, category and path — plus `MessageVersion`, `TreeElement`/`TreeElementType` and `SubProcess`.

Two more packages matter because the rules refer to them: `converter` (`Converter`, `DefaultConverter` — the non-deprecated parameter (de)serialization layer) and `logmessage/interfaces` (`ILogMessage`, `IActivity`, `IPluginDataItem` — the interfaces consumers build against, which is why deprecating a method there means annotating every override too; see `.claude/rules/api-stability.md`).

### The model classes *are* the protocol

There are **no serialization annotations anywhere** (no Jackson, JAXB, etc.) and no JSON library dependency. Binding is done entirely by the consumers (nJAMS SDK and server), driven by bean property names. Consequence: renaming a field or getter, changing a type, or changing an enum constant name is a **breaking protocol change** against server and client versions already in the field — and nothing in this repo will fail to compile. This is governed by a hard confirmation gate; see `.claude/rules/wire-contract.md` before touching any model type.

Enums that cross the wire often carry an explicit stable value separate from the constant name. Read it through the accessor (`ActivityStatus.numericStatus()`, `projectmessage.LogLevel.value()`, `MessageVersion.getValue()`) and resolve a received value through the matching lookup (`ActivityStatus.byNumericStatus`/`byName`, `LogLevel.getFromValue`, `MessageVersion.getMessageVersion`, `RuleType`/`AttributeType.fromValue`) — never `valueOf` or `ordinal`.

The only runtime dependency is `slf4j-api`, scoped `provided` — keep it that way (see `.claude/rules/code-quality.md`).

### Three classes named `Activity`

`logmessage.Activity` (an executed step), `projectmessage.Activity` (a modelled step) and `tracemessage.Activity` (a trace target) are unrelated types, as are `projectmessage.ProcessModel` and `tracemessage.ProcessModel`. Always check which package an import or JavaDoc reference means.

### Command / Instruction layer

`Instruction` wraps a `Request` and a `Response`, each of which carries `Map<String, String> parameters`. Parameter keys are **case-insensitive by contract** — read them via `Instruction.getRequestParameterByName()` / `getResponseParameterByName()`, which do the case-insensitive lookup, not via `getParameters().get(...)`. Command strings are matched case-insensitively too (`Command.getFromCommandString`).

Adding a command means: a constant in the `Command` enum (with its wire string) and agreement on parameter keys with nJAMS Server — nothing else in this repo.

### Deprecated wrapper layer

Everything under `command/wrapper/**` is `@Deprecated(since = "5.0.0", forRemoval = true)`; its removal is tracked by MSG-26. `converter/Converter` + `DefaultConverter` are the non-deprecated replacement for the parameter (de)serialization half of `InstructionMapper`. See `.claude/rules/deprecated-command-wrapper.md`.

## Release & CI

- **`Jenkinsfile` is the pipeline actually in use** (`mvn clean deploy`, JDK 11, Maven 3.8.5). Every release commit on `origin/master` — `njams-messageformat-5.0.1` included — and every JavaDoc commit on `origin/gh-pages` is authored by `Jenkins <jenkins@vsljenkins01.integrationmatters.com>`. Note it still passes `-Pjenkins-cli,svn-check`, profiles that no longer exist in `pom.xml` — Maven only warns.
- **`.github/workflows/release.yml` is not yet in service.** It is a manual `workflow_dispatch` running `mvn release:prepare release:perform`, attaching jars to a GitHub release and publishing JavaDoc to `gh-pages`. Migrating the build to it is tracked by **MSG-28**, still open. Do not treat this file as the source of truth for how a release currently happens, and treat it as untested against reality until that ticket is done.
- Deployment target is the Salesfive Nexus (`nexus.service.salesfive.io`), releases and snapshots.
- Release tags are `njams-messageformat-<version>`, with `-RC*`/`-TEST*` suffixes for non-final builds. Version bumps in `pom.xml` are made by the maven-release-plugin, never by hand.

## Additional Rules (`.claude/rules/`)

Topic-specific rules that apply either always or only when working with certain files.

**Ticket completion checks:** a rule file may contain a section titled `## Ticket completion checks` listing steps to carry out before a ticket is resolved. The `njams-ticket-finish` skill reads these sections from every rule whose path scope matches the ticket's diff, so project-specific completion steps live in the rule that owns them and not in the skill.

| Rule file | Applies to | Topic |
|---|---|---|
| `wire-contract.md` | always | The change-confirmation gate, `SER`/`SDK` alignment, wire format vs. Java API |
| `jira-workflow.md` | always | Ticket lifecycle, labels, fix version, descriptions, closing comments |
| `commit-conventions.md` | always | Smart Commit message format, branching policy, pushing |
| `code-quality.md` | `src/main/java/**/*.java` | Copyright header, dependency policy, Java level, general principles |
| `api-stability.md` | `src/main/java/**/*.java` | Public API immutability, visibility, Javadoc requirements and verification |
| `testing-conventions.md` | `src/**` | Test stack, what is worth testing in a data model, isolation, bug-fix rules |
| `deprecated-command-wrapper.md` | `src/*/java/.../v4/command/wrapper/**` | Standing deprecation policy for the typed instruction wrappers |

## Skills (`.claude/skills/`)

| Skill | Use when |
|---|---|
| `njams-ticket-start` | Starting work on an `MSG` ticket — bookkeeping, wire-format impact, approach confirmation |
| `njams-commit` | Immediately before every `git commit` |
| `njams-ticket-finish` | Closing out an `MSG` ticket the user is actually ready to resolve |
