# Longest Strictly Increasing or Strictly Decreasing Subarray

**Difficulty:** Easy

## Problem Statement

You are given an array of integers `nums`. Return the length of the longest subarray of `nums` which is either strictly increasing or strictly decreasing.

## Examples

**Example 1**
```
Input:  nums = [1, 4, 3, 3, 2]
Output: 2
Explanation:
  Longest strictly increasing subarray:  [1, 4] → length 2
  Longest strictly decreasing subarray:  [4, 3] or [3, 2] → length 2
  Hence, we return 2.
```

**Example 2**
```
Input:  nums = [3, 3, 3, 3]
Output: 1
Explanation:
  No two adjacent elements are strictly increasing or decreasing.
  The longest subarray has length 1.
```

**Example 3**
```
Input:  nums = [3, 2, 1]
Output: 3
Explanation:
  The entire array [3, 2, 1] is strictly decreasing → length 3.
  Hence, we return 3.
```

## Constraints

- `1 <= nums.length <= 50`
- `1 <= nums[i] <= 50`
