---
globs: "src/main/java/**/*.java"
---

# Code Quality

Applies to production code. Code quality rules do not apply to test code.

## Copyright Header

Every **new** production source file must begin with this copyright header:

```java
/*
 * Copyright (c) 2026 Salesfive Integration Services GmbH
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge,
 * publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 * the Software.
 *
 * The Software shall be used for Good, not Evil.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 *  FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */
```

The existing files still carry the older `Faiz & Siegeln Software GmbH` header, as does the `licenseheader.txt` IDE template. Migrating them is tracked by **MSG-30** — do not relicense existing files as a drive-by change while working on something else. No Maven plugin inserts or enforces this header; add it by hand.

The header does not apply to test files.

## General Principles

- **Prefer imports over fully qualified class names.** Reach for fully qualified names only when a same-simple-name conflict in the file leaves no other option. This repository has three unrelated classes named `Activity` (`logmessage`, `projectmessage`, `tracemessage`) and two named `ProcessModel` (`projectmessage`, `tracemessage`), so this case is real here — import the type used most in the file and fully qualify the other.
- **Self-documenting code.** Names should express intent clearly enough that comments are rarely needed. A comment is warranted only when the *why* is non-obvious.
- **Keep comments truthful when changing code.** Whenever you modify code, double-check that every nearby comment is still correct — both Javadoc (on the changed member and on any member that references it) and inline comments. Never leave a stale comment describing the old behavior.
- **No unnecessary complexity.** This project is strictly scoped to defining the wire format. It carries no runtime logic, no transport code, and no behavior beyond data carriage. Do not introduce abstractions, patterns, frameworks or generalisations that have no current use — and do not add functionality that belongs in the SDK or the Server to this project at all. When a proposed change would put behavior here, say so and ask.
- **DRY within reason.** Eliminate duplication, but do not create premature abstractions to unify code that merely looks similar. The near-identical shape of the message model classes is intentional, not duplication to be factored away: each is an independent part of the wire contract and they must be free to diverge.
- **Delegate, don't duplicate.** When adding an overload or alternative entry point for an existing method, have the new method adapt its input and call through to the canonical implementation.

## Dependencies

**This library has no runtime dependencies**, and that is a feature: it is embedded in every nJAMS client, inside host applications whose classpaths are not under our control. `slf4j-api` is `provided`; JUnit, Mockito and `slf4j-log4j12` are `test`.

**Do not add a runtime dependency.** Solve problems with the Java standard library. In particular, do not add a JSON/XML binding library or its annotations — serialization belongs to the consumers (see `wire-contract.md`). If a new dependency seems genuinely necessary, stop and ask; when one is approved, check online for the latest stable version and use that.

## Java level

Source and target level is Java 11 (`javaSourceLevel` in `pom.xml`). Do not use language or API features beyond Java 11 — clients embed this library in long-lived runtimes.
