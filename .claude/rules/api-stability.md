---
globs: "src/main/java/**/*.java"
---

# API Stability and Javadoc

This library is consumed by nJAMS Server and by every nJAMS SDK version in the field. Two different contracts live in the same source tree — the **wire format** (governed by `wire-contract.md`) and the **Java API** (governed by this rule). A member can belong to one, the other, or both.

## Immutability of Existing Public API

**All existing `public` and `protected` members must be treated as in active use by nJAMS Server and the SDK, and must not be changed unless explicitly requested.** This is a hard rule, not a guideline. Changing a method signature, return type, behavior, or removing a member is a breaking change. If you identify a problem with an existing API, raise it with the user rather than fixing it silently.

**Extending the Java API with new methods or overloads is permitted without explicit request** — *provided it adds no bean property*. A new `getX()`/`setX()` pair is not an API extension here, it is a wire-format change, because the consumers' object mappers will pick it up: it goes through `wire-contract.md`'s gate. A helper, lookup static, or `isX()` convenience that reads existing state is a safe addition.

**When changing existing Java API is explicitly requested**, do not remove the old member. Keep it in place, mark it `@Deprecated(since = "<version>", forRemoval = <true|false>)`, and add a Javadoc `@deprecated` tag referencing the replacement:

```java
/**
 * @deprecated Use {@link #newMethod()} instead.
 */
@Deprecated(since = "5.0.2", forRemoval = false)
public void oldMethod() {
    newMethod(); // delegate to the new implementation where possible
}
```

Removal of an already-deprecated member is a separate, explicitly requested step — never a cleanup done in passing.

## Visibility

- **Prefer the most restrictive scope possible.** Consumers will use everything that is accessible, so anything not intended for external use must be actively hidden. Reserve `public` and `protected` for intentional API surface.
- **New public members are permanent commitments.** Adding one is easy; removing or changing it breaks Server and SDK.
- **Be deliberate about `protected`.** Protected members are API surface too — subclasses in external code can call them. `CommonMessage` is subclassed inside this project only, but its members are visible to consumers through all three of `LogMessage`, `ProjectMessage` and `TraceMessage`.

## Javadoc

**All `public` and `protected` members should have Javadoc** — classes, interfaces, methods, constructors and fields. For the message model types the Javadoc on a field is the only documentation of what a wire property means and whether it is required; write it as part of the change, not as an afterthought. Internal (`private`, package-private) members do not require it.

Javadoc states intent and contract, not implementation detail. Keep it short, and state restrictions plainly without justifying them.

### Inheritance and deprecation

- **Doc comments are inherited only by an override that has no comment at all.** As soon as the override has any comment, only what it writes itself is shown; use `{@inheritDoc}` to pull in individual parts.
- **Deprecation is never inherited** — neither the `@Deprecated` annotation nor the `@deprecated` tag. An override lacking them is documented as *not* deprecated and produces no compiler warning for callers using the implementing type. When deprecating a member that has public overrides (e.g. an interface method in `logmessage/interfaces/` and its implementation), put the full reasoning once on the declaring type and add the annotation plus a short pointer tag (`@deprecated See {@link ILogMessage#method()}.`) on every override.
- **`{@inheritDoc}` does not work inside `@deprecated`** — `javadoc` warns and drops the reason text.

### Verification

**Javadoc must build without errors before any commit** that touches `src/main/java`:

```bash
mvn generate-sources javadoc:javadoc
```

Output lands in `target/reports/apidocs/`. A broken `{@link}` or `@see` reference (e.g. pointing to a renamed or removed member) is a hard error that fails the build, not a warning. Delete the output folder first when inspecting generated pages — `javadoc:javadoc` may leave a stale page in place.

The published JavaDoc at https://integrationmatters.github.io/njams-messageformat/ is this project's only user-facing documentation, which is why its quality matters more than in a project with a wiki.

## Ticket completion checks

Before a ticket touching `src/main/java` is resolved:

- Confirm `mvn generate-sources javadoc:javadoc` completes without errors.
- Confirm the `breaking-change` label matches the actual diff for Java-API changes (see `jira-workflow.md`), and that wire-format changes went through `wire-contract.md`'s gate instead of the label.
