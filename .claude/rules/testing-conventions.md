---
globs: "src/test/**"
---

# Testing

Tests use JUnit 4 (4.13.2) and Mockito (5.23.0), with `slf4j-log4j12` and `src/test/resources/log4j.properties` for logging. There is no shared test base class — tests construct the objects they need directly. The one harness is `command/wrapper/example/` (`Client`, `Server`, `MessageQueue`, `MessageListener`), a small in-memory round-trip rig used by `InstructionWrapperTest`; it belongs to the deprecated wrapper layer and is not a general-purpose fixture to build new tests on.

Run them with `mvn test`; a single class with `mvn test -Dtest=InstructionMapperTest`, a single method with `mvn test -Dtest=InstructionMapperTest#methodName`. Reports are written to `target/surefire-reports/`.

Code quality and documentation rules (`code-quality.md`, `api-stability.md`) do not apply to test code.

## What is worth testing here

This project is a data model, so plain getter/setter round-trips carry no information and should not be tested. Test the code that actually makes a decision:

- parsing and serialization helpers (`converter/`, and the deprecated `InstructionMapper`) — especially their edge cases: `null`, empty and blank input, wrong case, trailing `Z` on ISO timestamps, out-of-range numbers
- case-insensitive lookups (`Instruction.getRequestParameterByName`, `Command.getFromCommandString`, `ActivityStatus.byName`)
- value-based enum lookups (`ActivityStatus.byNumericStatus`, `LogLevel.getFromValue`, `MessageVersion.getMessageVersion`, `RuleType`/`AttributeType.fromValue`), including the unmapped-value case
- defaults assigned at field declaration, where a consumer depends on them

Cover all new and changed logic of this kind with tests.

## Test Isolation for Shared State

A test must never assume the state a previous test left behind. If a test observes or depends on shared state — a static field, a shared fixture — it must establish that state itself in `@Before` rather than relying on the default condition or on what ran earlier, and restore it in `@After`. Test execution order must never be load-bearing for correctness.

In practice: install a fresh instance before each test rather than reading whatever is currently installed, and assert on absolute values rather than computing a before/after delta. A delta computation is a symptom of not trusting the starting state — fix the setup instead of compensating in the assertion.

## Bug fixes

**Existing test cases must never be modified without explicit user permission** — if a fix causes a test to fail, the fix is wrong. If there is genuine reason to believe a test is incorrect, explain the specific conflict and ask the user before changing anything.

When code relocates without behavior change, move its tests as-is with identical assertions — that parity is the proof the move preserved behavior.

## Ticket completion checks

Before a ticket touching `src/main/**` or `src/test/**` is resolved, confirm `mvn clean test` passes and report the actual result (test count, failures) rather than asserting success.
