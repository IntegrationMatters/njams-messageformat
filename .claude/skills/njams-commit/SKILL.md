---
name: njams-commit
description: Use immediately before running `git commit` in this repository, for every commit — not just the first one in a session. Verifies the staged diff actually matches the Jira ticket being referenced, checks whether the change touches the wire format, decides whether the commit is significant enough to carry the #comment tag, and formats the Smart Commit message. Trigger whenever the user says "commit this", "let's commit", "create a commit", "commit these changes", or similar, and also apply it proactively whenever you are about to commit as part of finishing a task, even if the user didn't explicitly ask for a commit in that exact message.
---

# Commit Crafting for nJAMS MessageFormat

## Overview

Every commit that touches code in this repo carries a Jira ticket reference, and that reference is only useful if it's actually correct — a ticket key copy-pasted from three commits ago because "it's probably still the same ticket" quietly breaks the audit trail. The `#comment` tag is a second decision that's easy to get wrong in either direction: use it on every commit and the Jira comment history turns into unreadable noise; forget it on the commit that actually finishes a ticket and there's no record of what shipped.

This repository adds a third check the SDK doesn't need: the staged diff may be a **wire-format change**, which no compiler and no test in this project will flag. A commit is the last point before that change becomes shareable, so it is worth one explicit look.

## Hard Rules

**Check whether the diff changes the wire format before anything else.** If the staged change adds, removes, renames or retypes a bean property, enum constant, class or package under `src/main/java`, it is a wire-format change (see `wire-contract.md`). Confirm that a human explicitly approved it. If that confirmation didn't happen, stop and get it — do not commit a wire-format change on the assumption it was implied by the task.

**Verify the diff matches the ticket before writing the message.** Check the ticket's summary (and description if needed) against what's actually staged. If they don't match — because the ticket changed scope, or this commit is really unrelated cleanup — propose a better-fitting recent ticket, or ask the user if none fits. Don't default to whatever ticket was mentioned earlier in the conversation without checking.

**If no ticket has been established for this work at all, ask before committing** — don't invent one and don't commit without a reference.

**Format every ticket-referencing commit as:**
```
MSG-XXX <description>
```
The description is required — never a bare ticket key. Keep it to one sentence, two at most, describing WHAT changed, not HOW.

**Add `#comment` only on significant commits** — the one that finalizes a ticket, or another clear milestone. Intermediate commits must NOT carry it, so the Jira comment history stays readable. When in doubt, leave it off: a missing comment can be added later by referencing the ticket again; a cluttered comment history can't be cleaned up.

**Exception: commits touching only documentation (`CLAUDE.md`, `README.md`, `.claude/**`) or build files (`pom.xml`, `Jenkinsfile`, `.github/workflows/**`)** don't need a ticket reference — use a plain message. Still reference `MSG-XXX` when the change obviously belongs to that ticket. Note that version changes in `pom.xml` are made by the maven-release-plugin, not by hand.

**Follow the repo's standard git safety practices**: create a new commit rather than amending, never skip hooks, don't force-push, and stage specific files rather than `git add -A`.

## Steps in Detail

**1. Look at what's actually staged (or about to be staged).**
Run `git status` / `git diff` and read the real change — not your memory of what the task was supposed to be.

**2. Classify the change.**
Does it touch the wire format (bean properties, enum constants, type/package names under `src/main/java`)? Does it break Java API? Both have consequences that outlive this commit — see `wire-contract.md` and `api-stability.md`.

**3. Identify the ticket.**
If one was given for this task, confirm the diff still matches its summary. If the work drifted, say so and propose the ticket that actually fits, or ask.

**4. Decide on `#comment`.**
Is this the commit that finishes the ticket, or a meaningful milestone worth surfacing in Jira? If it's just another step along the way, leave the tag off.

**5. Write the message.**
`MSG-XXX <description>` or `MSG-XXX #comment <description>`, with a real, specific description — not a restatement of the ticket title.

**6. Commit.**
Stage the specific files involved (not a blanket `git add -A`), then commit with the message via a heredoc so formatting survives.

## Common Mistakes

| Mistake | Correct Approach |
|---------|-----------------|
| Committing a renamed field or getter as if it were a refactor | It's a wire-format change — confirm `wire-contract.md`'s gate was satisfied first |
| Reusing the same ticket key across commits without re-checking | Verify the diff matches that specific commit's ticket every time |
| Tagging every commit with #comment | Reserve it for the commit that finishes the ticket or a clear milestone |
| Committing without any ticket when one hasn't been established | Ask the user for one first |
| Bare `MSG-XXX` with no description | Always include a real description after the ticket key |
| A commit body explaining the implementation | One or two sentences, no body — the diff shows how |
