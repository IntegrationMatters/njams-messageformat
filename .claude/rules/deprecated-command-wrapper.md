---
globs: "src/*/java/com/faizsiegeln/njams/messageformat/v4/command/wrapper/**"
---

# Command Wrapper Layer — Deprecated

Everything under `command/wrapper/**` is annotated `@Deprecated(since = "5.0.0", forRemoval = true)`: `InstructionMapper`, `InstructionConstants`, `RequestListener`/`ResponseListener`, the `InstructionParsingException` and `NjamsMessageFormatException` exception types, and the typed `*Request`/`*Response` classes. It was a typed facade over the string parameter map of `Instruction`. Its removal is tracked by **MSG-26** ("Remove unused command wrapper classes").

This is a standing policy, not a one-off judgment for a specific task:

- **No new feature investment.** Do not add new `*Request`/`*Response` wrapper classes, new `InstructionConstants` keys, or new methods here. Each new typed class also requires another branch in both listener interfaces' `default onInstruction(Instruction)` dispatch switches — exactly the cost that got the layer deprecated.
- **`converter/Converter` + `DefaultConverter` are the successor** for the parameter (de)serialization half of `InstructionMapper`. New conversion logic belongs there. Note that `DefaultConverter` parses ISO date-times with a hand-rolled fast parser and tolerates a trailing `Z` — keep that tolerance, nJAMS clients emit both forms.
- **Tests are best-effort.** This package is out of scope for the usual test expectations in `testing-conventions.md`. Do not block work on adding or fixing tests here unless specifically asked to.
- **Bug fixes and safe modifications are still permitted when explicitly requested.** This policy relaxes new-feature and test expectations; it does not license careless changes.
- **Deprecated status is not license to break compatibility silently.** These classes are still public API bound by `api-stability.md`, and the `Command` enum and parameter keys they encode are still the wire contract (`wire-contract.md`). Removing the layer is a `breaking-change` ticket of its own, not a cleanup.

Adding a new command does **not** require touching this package: it means a constant in the `Command` enum (with its wire string) plus agreement on parameter keys with nJAMS Server.
