# Assign Edge Weights with Queries

**Difficulty:** Medium

## Problem Statement

There is an undirected tree with `n` nodes labeled from `1` to `n`, rooted at node `1`. All edges initially have weight `0`. You must assign each edge a weight of either `1` or `2`.

The cost of a path between nodes `u` and `v` is the total weight of all edges on that path.

You are given a 2D integer array `queries`. For each `queries[i] = [ui, vi]`, determine the number of ways to assign weights to edges in the path such that the cost is odd.

Return an array `answer` where `answer[i]` is the number of valid assignments for `queries[i]`, modulo `10^9 + 7`.

**Note:** For each query, disregard all edges not in the path between `ui` and `vi`.

## Examples

**Example 1**
```
Input:  edges = [[1,2]], queries = [[1,1],[1,2]]
Output: [0, 1]
Explanation:
  - [1,1]: No edges in path, cost = 0 (even). Valid assignments = 0.
  - [1,2]: One edge. Weight 1 → odd cost. Valid assignments = 1.
```

**Example 2**
```
Input:  edges = [[1,2],[1,3],[3,4],[3,5]], queries = [[1,4],[3,4],[2,5]]
Output: [2, 1, 4]
Explanation:
  - [1,4]: Path has 2 edges (1→3, 3→4). Assignments (1,2) and (2,1) → 2.
  - [3,4]: Path has 1 edge (3→4). Only weight 1 works → 1.
  - [2,5]: Path has 3 edges. Four assignments give odd cost → 4.
```

## Constraints

- `2 <= n <= 10^5`
- `edges.length == n - 1`
- `1 <= queries.length <= 10^5`
- `1 <= ui, vi <= n`
- `edges` represents a valid tree.
