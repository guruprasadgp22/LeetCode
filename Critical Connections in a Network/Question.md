# Critical Connections in a Network

**Difficulty:** Hard

## Problem Statement

There are `n` servers numbered from `0` to `n - 1` connected by undirected `connections`, where `connections[i] = [ai, bi]` represents a connection between servers `ai` and `bi`. Any server can reach any other server directly or indirectly.

A **critical connection** is a connection that, if removed, will make some servers unable to reach some other server.

Return all critical connections in the network in any order.

## Examples

**Example 1**
```
Input:  n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: Removing [1,3] disconnects server 3 from the rest.
             [[3,1]] is also accepted.
```

**Example 2**
```
Input:  n = 2, connections = [[0,1]]
Output: [[0,1]]
```

## Constraints

- `2 <= n <= 10^5`
- `n - 1 <= connections.length <= 10^5`
- `0 <= ai, bi <= n - 1`
- `ai != bi`
- There are no repeated connections.
