# Maximum Distance Between a Pair of Prime Indices

**Difficulty:** Easy

## Problem Statement

You are given an integer array `nums`.

Return an integer that is the maximum distance between the indices of two (not necessarily different) prime numbers in `nums`.

## Examples

**Example 1**
```
Input:  nums = [4, 2, 9, 5, 3]
Output: 3
Explanation: nums[1]=2, nums[3]=5, and nums[4]=3 are prime.
             The maximum distance is |4 - 1| = 3.
```

**Example 2**
```
Input:  nums = [4, 8, 2, 8]
Output: 0
Explanation: nums[2]=2 is the only prime.
             The distance is |2 - 2| = 0.
```

## Constraints

- `1 <= nums.length <= 3 * 10^5`
- `1 <= nums[i] <= 100`
- The input is generated such that the number of prime numbers in `nums` is at least one.
