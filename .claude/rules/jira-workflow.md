# Jira Workflow

Issues and tasks for this project are tracked in Jira: **https://salesfive.atlassian.net** — project key **MSG**.

Related projects: **`SER`** (nJAMS Server) and **`SDK`** (nJAMS SDK). Changes here frequently require a counterpart ticket in one or both — see `wire-contract.md`.

**When inspecting a Jira ticket, always follow its linked issues.** Read not only the explicitly linked tickets (the issue-link relationships such as "relates to", "blocks", "is caused by"), but also any tickets referenced inline in the ticket's text — summary, description, and comments (e.g. an `MSG-123`, `SER-456` or `SDK-789` mentioned in a sentence). Both inline references and formal links may carry context, constraints, or prior decisions essential to the current work. Cross-project references matter more here than in a self-contained repository: the reason a field exists usually lives in a `SER` or `SDK` ticket, not in `MSG`.

**When creating a new Jira ticket, always set the `fix version` field** to the current working copy's version with the `-SNAPSHOT` suffix stripped. Read the version from `pom.xml`. Example: working on `5.0.2-SNAPSHOT` → fix version `5.0.2`. If the working copy is behind its remote, check `git show origin/<branch>:pom.xml` — a stale local pom will otherwise produce a fix version that has already been released. Never create a ticket autonomously — propose it and wait for explicit confirmation first.

**Setting the fix version takes two calls, and verifying it takes a third — all three failure modes are silent.** `createJiraIssue` drops `fixVersions` passed in `additional_fields`: it reports success and the field is simply absent. Set it afterwards with `editJiraIssue` (`fields: {"fixVersions": [{"id": "<version id>"}]}`), always by **id** — the `{"name": "5.0.2"}` form is dropped just as silently. Resolve the id with the `getJiraProjectVersions` operation via `executeRead`. Then confirm it: neither the default nor the `evidence` view of `getJiraIssue` returns `fixVersions` at all, so an ordinary read-back looks identical whether the field was set or not. Only `fields: ["fixVersions"]` shows the truth.

## Ticket Scope Is Fixed — Reframe Internally, Don't Split to a New Ticket

If a ticket's actual scope turns out larger than expected, **do not propose splitting the excess scope into a new Jira ticket.** Jira tickets here track issues, not a backlog; carving out a "part 2" ticket defers work the original ticket is supposed to cover and makes the original look done when it isn't. All work described by (or discovered to belong to) a ticket stays under that same ticket, however many sessions it takes, and the ticket is complete only once every sub-task identified during reframing is actually done.

**Exception — a genuinely distinct issue.** If work on a ticket surfaces an unrelated problem in its own right, **propose creating a new Jira ticket for it** as soon as it is recognized, rather than folding it into the current ticket's scope or silently fixing it on the side. The test for "distinct" vs. "part of this ticket's scope": would this still need fixing if the current ticket did not exist? If yes, it's a separate ticket.

## Labels

**Manage the `breaking-change` label for Java-API breaks.** Add it if the work changes or removes an existing public/protected member's signature, return type, parameter type, or observable behavior. Remove it if present and the work turned out purely additive. Adding new methods, classes, or overloads is not breaking. Check at the start of the ticket and again before declaring it done.

**Do not use the `breaking-change` label for wire-format changes.** Those are governed by the confirmation gate and `SER`/`SDK` alignment in `wire-contract.md`, not by a label. A ticket can legitimately carry both when it changes the wire format *and* breaks Java API.

## Status and assignment

**When starting work on a Jira ticket, transition it to `In Progress`** (unless it is already in a started or done state). In the MSG workflow that transition is named **`Start Progress`** (id 21) — passing the target status name `In Progress` fails, because the transition and the status it leads to have different names. From `New / Open` the available transitions are `Start Progress`, `Feedback`, `Reject` and `Reopen` and **assign it to the current Atlassian plugin user** (call `atlassianUserInfo` to get the `account_id`, then set that as the assignee). If the ticket is already assigned to a different user, ask before changing the assignee. Do this after the ticket key is confirmed and before making any code changes.

**When resolving a Jira ticket, set the resolution to `Done` and the assignee to unassigned.** An empty resolution is treated by Jira as *unresolved* even in a done status, which blocks releasing its fix version — pass the resolution on the resolve transition, then read the ticket back to confirm it, since the transition reports success either way.

## Content

**Jira ticket descriptions** focus on WHAT is needed, not HOW it is implemented. No design decisions or implementation details belong in the description, even when the ticket is created after the work is done. Structure every description in two parts:
1. **Brief summary** — a short abstract readable in ~30 seconds.
2. **Detail section** — context, constraints, and acceptance criteria needed to understand the task; still no implementation decisions.

**Closing comments** should be brief: state that the issue is resolved and optionally note the root cause. Do not include deep technical detail about how the solution was implemented — that belongs in commit messages. Post closing/summary comments only when the user actually resolves the ticket, not as soon as the work feels done.

**While working on a ticket, end responses with the ticket key, title, and status.**

**Write all Jira bodies (descriptions, comments) in Markdown** with `contentFormat=markdown`. Never use wiki markup (`h2.`, `_..._`, `*..*`) — it renders broken.

All content posted to Jira by Claude Code must end with the following signature:

```
---
_Generated by Claude Code_
```
