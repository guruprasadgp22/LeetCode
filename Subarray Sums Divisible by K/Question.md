# Subarray Sums Divisible by K

**Difficulty:** Medium

## Problem Statement

Given an integer array `nums` and an integer `k`, return the number of non-empty subarrays that have a sum divisible by `k`.

A subarray is a contiguous part of an array.

## Examples

**Example 1**
```
Input:  nums = [4, 5, 0, -2, -3, 1], k = 5
Output: 7
Explanation: The 7 subarrays with sum divisible by 5 are:
             [4,5,0,-2,-3,1], [5], [5,0], [5,0,-2,-3], [0], [0,-2,-3], [-2,-3]
```

**Example 2**
```
Input:  nums = [5], k = 9
Output: 0
```

## Constraints

- `1 <= nums.length <= 3 * 10^4`
- `-10^4 <= nums[i] <= 10^4`
- `2 <= k <= 10^4`
