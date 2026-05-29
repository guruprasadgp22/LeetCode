# Minimum Number of Operations to Make Array Empty

**Difficulty:** Medium

## Problem Statement

You are given a 0-indexed array `nums` consisting of positive integers.

There are two types of operations that you can apply on the array any number of times:

- Choose two elements with equal values and delete them from the array.
- Choose three elements with equal values and delete them from the array.

Return the minimum number of operations required to make the array empty, or `-1` if it is not possible.

## Examples

**Example 1**
```
Input:  nums = [2,3,3,2,2,4,2,3,4]
Output: 4
Explanation:
  - Delete nums[0] and nums[3] (both 2) → [3,3,2,4,2,3,4]
  - Delete nums[2] and nums[4] (both 2) → [3,3,4,3,4]
  - Delete nums[0], nums[1], nums[3] (all 3) → [4,4]
  - Delete nums[0] and nums[1] (both 4) → []
  Total: 4 operations.
```

**Example 2**
```
Input:  nums = [2,1,2,2,3,3]
Output: -1
Explanation: It is impossible to empty the array.
```

## Constraints

- `2 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^6`
