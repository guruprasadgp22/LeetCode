# Rotting Oranges

**Difficulty:** Medium

## Problem Statement

You are given an `m x n` grid where each cell can have one of three values:

- `0` — empty cell
- `1` — fresh orange
- `2` — rotten orange

Every minute, any fresh orange 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes until no fresh oranges remain. If this is impossible, return `-1`.

## Examples

**Example 1**
```
Input:  grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
```

**Example 2**
```
Input:  grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The bottom-left orange is never reached (rotting is 4-directional only).
```

**Example 3**
```
Input:  grid = [[0,2]]
Output: 0
Explanation: No fresh oranges exist at minute 0.
```

## Constraints

- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 10`
- `grid[i][j]` is `0`, `1`, or `2`.
