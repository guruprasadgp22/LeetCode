# Length of Longest Subarray With at Most K Frequency

**Difficulty:** Medium

## Problem Statement

You are given an integer array `nums` and an integer `k`.

An array is called **good** if the frequency of each element is less than or equal to `k`.

Return the length of the longest good subarray of `nums`.

## Examples

**Example 1**
```
Input:  nums = [1,2,3,1,2,3,1,2], k = 2
Output: 6
Explanation: [1,2,3,1,2,3] has each element occurring at most 2 times.
```

**Example 2**
```
Input:  nums = [1,2,1,2,1,2,1,2], k = 1
Output: 2
Explanation: [1,2] has each element occurring at most 1 time.
```

**Example 3**
```
Input:  nums = [5,5,5,5,5,5,5], k = 4
Output: 4
Explanation: [5,5,5,5] has 5 occurring exactly 4 times.
```

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
- `1 <= k <= nums.length`
