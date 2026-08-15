# Longest Subsequence With Non-Zero Bitwise XOR

**Difficulty:** Medium

## Problem Statement

You are given an integer array `nums`.

Return the length of the longest subsequence in `nums` whose bitwise XOR is non-zero. If no such subsequence exists, return `0`.

## Examples

**Example 1**
```
Input:  nums = [1,2,3]
Output: 2
Explanation: Subsequence [2,3] has XOR = 2 XOR 3 = 1 (non-zero).
```

**Example 2**
```
Input:  nums = [2,3,4]
Output: 3
Explanation: Subsequence [2,3,4] has XOR = 2 XOR 3 XOR 4 = 5 (non-zero).
```

## Constraints

- `1 <= nums.length <= 10^5`
- `0 <= nums[i] <= 10^9`
