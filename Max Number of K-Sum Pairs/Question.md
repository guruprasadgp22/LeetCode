# Max Number of K-Sum Pairs

**Difficulty:** Medium

## Problem Statement

You are given an integer array `nums` and an integer `k`.

In one operation, you can pick two numbers from the array whose sum equals `k` and remove them from the array.

Return the maximum number of operations you can perform on the array.

## Examples

**Example 1**
```
Input:  nums = [1, 2, 3, 4], k = 5
Output: 2
Explanation:
  - Remove 1 and 4 → nums = [2, 3]
  - Remove 2 and 3 → nums = []
  Total of 2 operations.
```

**Example 2**
```
Input:  nums = [3, 1, 3, 4, 3], k = 6
Output: 1
Explanation:
  - Remove the first two 3's → nums = [1, 4, 3]
  No more pairs sum to 6. Total of 1 operation.
```

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
- `1 <= k <= 10^9`
