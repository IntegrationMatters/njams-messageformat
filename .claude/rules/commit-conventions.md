# Commit Message Convention & Branching

## Scope of the ticket-reference requirement

The Jira ticket-reference requirement applies to code changes under `src/main/**` and `src/test/**`. A commit needs a ticket reference if it touches any file under either of those paths, regardless of what else it also touches.

Commits that touch **only** other files — documentation (`CLAUDE.md`, `README.md`, `.claude/**`), or build-related files (`pom.xml`, `Jenkinsfile`, `.github/workflows/**`) — do not need a Jira ticket reference. Use a plain descriptive message for those, though referencing `MSG-XXX` is still appropriate when the change obviously relates to that ticket.

**The ticket reference can be waived per commit, but only by an explicit statement from the user in the same conversation that no ticket is needed for that specific commit.** Silence, a bare "commit this", or reasoning that the change is "just" a Javadoc/comment/small edit does not waive it — the requirement applies regardless of how small or low-risk the change looks. Only the user's own explicit waiver skips it, and it applies to that commit only.

## Format

Every commit that needs a ticket reference must reference the related Jira ticket using the Jira Smart Commits format:

```
MSG-XXX <description>
```

Every commit that references a ticket must include a description — never a bare ticket key. The `#comment` token (`MSG-XXX #comment <description>`) posts the commit message automatically as a comment on the Jira ticket — use it **only on significant commits**, for instance the commit that finalizes a ticket. Intermediate commits (e.g. the individual steps while executing an implementation plan) must NOT carry the `#comment` tag, so the Jira comment history is not cluttered. If no ticket exists for the work being committed, ask the user to provide one before committing.

**Commit messages are short and precise: one sentence, two at most, about WHAT changed, not HOW.** No body unless the user explicitly asks for one — the details belong in the diff and in the ticket.

**Before every commit, verify that the referenced ticket actually matches the change.** Check the ticket's summary (and description if needed) against the diff. If the ticket does not describe what is being committed, propose a recent ticket that better fits. If none exists, ask the user before committing.

## Branching

`master` carries current development; `4.0.X` and `4.1.X` are maintenance branches. `origin` also holds `github_dev` and `gh-pages` — `gh-pages` is the published JavaDoc, written by CI, and is never committed to by hand.

**A change belongs to the release defined by the current branch's `pom.xml`** (version with `-SNAPSHOT` stripped). Always read it from the pom, never infer it from the branch name — and check the pom on the remote branch if the local checkout may be behind, since the maven-release-plugin bumps this version on every release. Before starting work on a ticket, check that this version matches the ticket's fix version; if it doesn't, stop and ask which branch to use.

**Merging is exclusively the user's decision — HARD rule.** When to merge, what to merge, and into which target is always decided by the user. Never decide on a merge, and never propose or suggest one — not at session start, not when a branch is behind, not as an option in a menu. Merge only when the user explicitly asks for a specific merge.

**Before running a requested merge, check only its reasonability:**

- A fix may be backported into another major/minor line's branch, or forwarded into a future development branch.
- A fix must never go into an already released version. The target branch counts as released when its pom version (without `-SNAPSHOT`) already has a final release tag, i.e. `git tag -l "njams-messageformat-<version>"` returns a tag that is not an `-RC*`/`-TEST*` build.
- If the check fails, report why instead of merging; otherwise perform exactly the requested merge.

**Only exception: worktree branches.** A worktree branch is temporary and exists only to be merged back once its work is complete. Merging it back may therefore be offered, but only into the branch it was created from, never into any other target. **Always ask for explicit confirmation before actually merging it back**, because the origin branch may have work in progress of its own.

Do not create additional branches unless explicitly requested.

## Pushing

Never push on your own initiative. Wait for an explicit, per-action "push" request — a prior push does not authorize the next one.

Note that `pom.xml` version-bump commits are produced by the maven-release-plugin during a release, not by hand. Do not hand-edit the project version to "prepare" a release.
