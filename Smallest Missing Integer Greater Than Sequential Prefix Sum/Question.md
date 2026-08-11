# Smallest Missing Integer Greater Than Sequential Prefix Sum

**Difficulty:** Easy

## Problem Statement

You are given a 0-indexed integer array `nums`.

A prefix `nums[0..i]` is **sequential** if, for all `1 <= j <= i`, `nums[j] = nums[j-1] + 1`. The prefix consisting only of `nums[0]` is sequential.

Return the smallest integer `x` missing from `nums` such that `x` is greater than or equal to the sum of the longest sequential prefix.

## Examples

**Example 1**
```
Input:  nums = [1,2,3,2,5]
Output: 6
Explanation: Longest sequential prefix is [1,2,3] with sum 6. 6 is not in the array.
```

**Example 2**
```
Input:  nums = [3,4,5,1,12,14,13]
Output: 15
Explanation: Longest sequential prefix is [3,4,5] with sum 12.
             12, 13, 14 are in the array; 15 is not.
```

## Constraints

- `1 <= nums.length <= 50`
- `1 <= nums[i] <= 50`
