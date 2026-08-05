# Remove Methods From Project

**Difficulty:** Medium

## Problem Statement

You are maintaining a project with `n` methods numbered from `0` to `n - 1`.

You are given two integers `n` and `k`, and a 2D integer array `invocations`, where `invocations[i] = [ai, bi]` means method `ai` invokes method `bi`.

Method `k` has a known bug. Method `k`, along with any method it invokes (directly or indirectly), is considered **suspicious**. A group of suspicious methods can only be removed if no method outside the group invokes any method within it.

Return an array of all remaining methods after removing suspicious methods. If it is not possible to remove all suspicious methods, none should be removed.

## Examples

**Example 1**
```
Input:  n=4, k=1, invocations=[[1,2],[0,1],[3,2]]
Output: [0,1,2,3]
Explanation: Methods 1 and 2 are suspicious, but methods 0 and 3 invoke them.
             Cannot remove — return all methods.
```

**Example 2**
```
Input:  n=5, k=0, invocations=[[1,2],[0,2],[0,1],[3,4]]
Output: [3,4]
Explanation: Methods 0, 1, 2 are suspicious and not invoked by outside methods.
             Remove them; keep 3 and 4.
```

**Example 3**
```
Input:  n=3, k=2, invocations=[[1,2],[0,1],[2,0]]
Output: []
Explanation: All methods are suspicious and can be removed.
```

## Constraints

- `1 <= n <= 10^5`
- `0 <= k <= n - 1`
- `0 <= invocations.length <= 2 * 10^5`
- `ai != bi`, all invocation pairs are unique.
