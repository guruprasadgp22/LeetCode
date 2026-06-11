# Assign Edge Weights to Maximize Odd Path Cost

**Difficulty:** Medium

## Problem Statement

There is an undirected tree with `n` nodes labeled from `1` to `n`, rooted at node `1`. All edges initially have weight `0`. You must assign each edge a weight of either `1` or `2`.

The cost of a path between nodes `u` and `v` is the total weight of all edges on the path.

Select any one node `x` at the maximum depth. Return the number of ways to assign edge weights in the path from node `1` to `x` such that its total cost is odd.

Since the answer may be large, return it modulo `10^9 + 7`.

## Examples

**Example 1**
```
Input:  edges = [[1,2]]
Output: 1
Explanation: Path 1→2 has one edge. Assigning weight 1 gives odd cost (valid), weight 2 gives even (invalid). Answer = 1.
```

**Example 2**
```
Input:  edges = [[1,2],[1,3],[3,4],[3,5]]
Output: 2
Explanation: Max depth is 2 (nodes 4 and 5). Path 1→3→4 has two edges.
             Assignments (1,2) and (2,1) both give odd cost. Answer = 2.
```

## Constraints

- `2 <= n <= 10^5`
- `edges.length == n - 1`
- `1 <= ui, vi <= n`
- `edges` represents a valid tree.
