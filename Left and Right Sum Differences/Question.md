# Check Knight Tour Configuration

**Difficulty:** Medium

## Problem Statement

There is a knight on an `n x n` chessboard. In a valid configuration, the knight starts at the top-left cell and visits every cell on the board exactly once.

You are given an `n x n` integer matrix `grid` consisting of distinct integers from the range `[0, n * n - 1]` where `grid[row][col]` indicates that the cell `(row, col)` is the `grid[row][col]th` cell that the knight visited. The moves are 0-indexed.

Return `true` if `grid` represents a valid configuration of the knight's movements or `false` otherwise.

A valid knight move consists of moving two squares vertically and one square horizontally, or two squares horizontally and one square vertically.

## Examples

**Example 1**
```
Input:  grid = [[0,11,16,5,20],[17,4,19,10,15],[12,1,8,21,6],[3,18,23,14,9],[24,13,2,7,22]]
Output: true
```

**Example 2**
```
Input:  grid = [[0,3,6],[5,8,1],[2,7,4]]
Output: false
Explanation: The 8th move of the knight is not valid given its position after the 7th move.
```

## Constraints

- `n == grid.length == grid[i].length`
- `3 <= n <= 7`
- `0 <= grid[row][col] < n * n`
- All integers in `grid` are unique.

---

# Left and Right Sum Differences

**Difficulty:** Easy

## Problem Statement

You are given a 0-indexed integer array `nums` of size `n`.

Define two arrays `leftSum` and `rightSum` where:

- `leftSum[i]` is the sum of elements to the left of index `i`. If no such element, `leftSum[i] = 0`.
- `rightSum[i]` is the sum of elements to the right of index `i`. If no such element, `rightSum[i] = 0`.

Return an integer array `answer` of size `n` where `answer[i] = |leftSum[i] - rightSum[i]|`.

## Examples

**Example 1**
```
Input:  nums = [10, 4, 8, 3]
Output: [15, 1, 11, 22]
Explanation:
  leftSum  = [0, 10, 14, 22]
  rightSum = [15, 11, 3, 0]
  answer   = [|0-15|, |10-11|, |14-3|, |22-0|] = [15, 1, 11, 22]
```

**Example 2**
```
Input:  nums = [1]
Output: [0]
Explanation: leftSum = [0], rightSum = [0], answer = [|0-0|] = [0].
```

## Constraints

- `1 <= nums.length <= 1000`
- `1 <= nums[i] <= 10^5`
