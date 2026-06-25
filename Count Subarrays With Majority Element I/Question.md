# Number of Subarrays Where Target Is the Majority Element

**Difficulty:** Medium

## Problem Statement

You are given an integer array `nums` and an integer `target`.

Return the number of subarrays where `target` is the majority element (appears strictly more than half the time in that subarray).

## Examples

**Example 1**
```
Input:  nums = [1,2,2,3], target = 2
Output: 5
Explanation: Valid subarrays where 2 is majority: [2], [2], [2,2], [1,2,2], [2,2,3].
```

**Example 2**
```
Input:  nums = [1,1,1,1], target = 1
Output: 10
Explanation: All 10 subarrays have 1 as the majority element.
```

**Example 3**
```
Input:  nums = [1,2,3], target = 4
Output: 0
Explanation: target=4 does not appear in nums at all.
```

## Constraints

- `1 <= nums.length <= 1000`
- `1 <= nums[i] <= 10^9`
- `1 <= target <= 10^9`
