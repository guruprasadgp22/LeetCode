# Number of Islands

**Difficulty:** Medium

## Problem Statement

Given an `m x n` 2D binary grid `grid` which represents a map of `'1'`s (land) and `'0'`s (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are surrounded by water.

## Examples

**Example 1**
```
Input:
grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
```

**Example 2**
```
Input:
grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
```

## Constraints

- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 300`
- `grid[i][j]` is `'0'` or `'1'`.

---

# Maximum Total Value of Chosen Subarrays

**Difficulty:** Medium

## Problem Statement

You are given an integer array `nums` of length `n` and an integer `k`.

You need to choose exactly `k` non-empty subarrays `nums[l..r]`. Subarrays may overlap, and the same subarray can be chosen more than once.

The value of a subarray `nums[l..r]` is: `max(nums[l..r]) - min(nums[l..r])`.

Return the maximum possible total value (sum of values of all chosen subarrays).

## Examples

**Example 1**
```
Input:  nums = [1,3,2], k = 2
Output: 4
Explanation:
  - Choose [1,3]: value = 3-1 = 2
  - Choose [1,3,2]: value = 3-1 = 2
  Total = 4.
```

**Example 2**
```
Input:  nums = [4,2,5,1], k = 3
Output: 12
Explanation:
  - Choose [4,2,5,1] three times (or similar): each has value 5-1 = 4.
  Total = 12.
```

## Constraints

- `1 <= n == nums.length <= 5 * 10^4`
- `0 <= nums[i] <= 10^9`
- `1 <= k <= 10^5`
