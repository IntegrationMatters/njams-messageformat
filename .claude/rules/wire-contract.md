# The Wire Contract Is This Project

This repository **is** the nJAMS wire format. Everything under `src/main/java` is the interface between nJAMS Server and every nJAMS client/SDK version in the field. The project's scope is strictly limited to defining that format — it holds no runtime logic, no transport code, and no behavior beyond data carriage.

Consumers that bind against these types:

- **nJAMS SDK** — locally at `../sdk-6.1-dev/`, on GitHub at https://github.com/IntegrationMatters/njams-sdk (Jira key `SDK`)
- **nJAMS Server** — Jira key `SER`

## Why a rename is a breaking change here

There are **no serialization annotations anywhere** in this project and no JSON/XML library dependency. Serialization is performed entirely by the consumers, driven by **bean property names** via their own object mappers. Consequences:

- Renaming a field or its getter/setter, changing a property's type, or renaming an enum constant **silently breaks** deployed servers and clients. Nothing in this repository fails to compile, no test fails, and the damage appears only at runtime against a mismatched counterpart.
- The compiler is not a safety net for this contract. Reviews and the confirmation gate below are.
- Enum constants that cross the wire usually carry an explicit stable value separate from the constant name — read through an accessor (`ActivityStatus.numericStatus()`, `projectmessage.LogLevel.value()`, `MessageVersion.getValue()`) and resolved through a lookup (`ActivityStatus.byNumericStatus`/`byName`, `LogLevel.getFromValue`, `MessageVersion.getMessageVersion`, `RuleType`/`AttributeType.fromValue`). Changing a constant's *name* is a wire change; changing its stable value is a wire change too, and a worse one.

## Change gate — HARD rule

**Any change to the wire format must be explicitly confirmed by a human before being made.** Never modify message-format types or wire-format fields on your own initiative — not while fixing something else, not as a drive-by cleanup, not because a name looks wrong.

A change is a wire-format change if it alters anything a consumer's object mapper can observe:

- adding, removing, renaming or retyping a field, getter or setter on any type under `logmessage/`, `projectmessage/`, `tracemessage/`, `common/` or `command/`
- adding, removing or renaming an enum constant, or changing its stable numeric/string value
- renaming or moving a class or package
- changing a default value assigned at field declaration (e.g. `LogMode.COMPLETE`, `MessageVersion.V4`, `Boolean.FALSE`)

The deprecated `command/wrapper/**` layer sits under `command/` but is deliberately **not** governed by this gate: its classes are a typed facade over `Instruction`'s string parameter map, not message types a mapper binds to. It is Java-API-only — see the table below, `api-stability.md` and `deprecated-command-wrapper.md`. This overlap is intended; do not "fix" it by widening the gate.

Adding a *new* field is the least dangerous change but is still a wire change: an older counterpart will not know it, and some mappers fail on unknown properties. It goes through this gate like any other.

**Changes must always be aligned with the nJAMS Server implementation.** When a change requires a corresponding adaptation in nJAMS Server, create a Jira ticket in the **`SER`** project to track that work (proposing it first — see `jira-workflow.md`). The same applies to the SDK side (**`SDK`**) when the SDK must be adapted to consume the change.

**Backward compatibility is the default expectation.** Prefer additive changes. If a change cannot be backward compatible, say so explicitly when asking for confirmation, and name which server and SDK versions it breaks against.

## Java API vs. wire format

Not every public member here is part of the wire format, and the two are governed differently:

| | Governed by | Jira signal |
|---|---|---|
| **Wire format** — the bean properties, enum constants and types the mappers bind to | this rule's confirmation gate + `SER`/`SDK` alignment | the gate, *not* a label |
| **Java-API-only** — convenience methods, helper/lookup statics, listener interfaces, the deprecated `command/wrapper/**` layer | `api-stability.md` | `breaking-change` label on the ticket |

`Instruction.getRequestParameterByName(...)`, `Command.getFromCommandString(...)` and `ActivityStatus.byNumericStatus(...)` are examples of Java-API-only members: removing one breaks compilation of a consumer, but no serialized message changes shape. Use the `breaking-change` label for those, and this gate for anything the mapper sees. When a change is both, apply both.

## Ticket completion checks

Before a ticket touching `src/main/java` is resolved:

- Confirm this gate was actually satisfied for the change: a human explicitly confirmed the wire-format modification. Do not resolve the ticket if it wasn't.
- Confirm that a `SER` ticket exists if nJAMS Server needs a corresponding adaptation, and an `SDK` ticket if the SDK does. If neither is needed, say so explicitly rather than leaving it unexamined.
