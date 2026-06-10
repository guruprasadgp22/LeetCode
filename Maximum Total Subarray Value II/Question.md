# Maximum Total Value of Distinct Chosen Subarrays

**Difficulty:** Medium

## Problem Statement

You are given an integer array `nums` of length `n` and an integer `k`.

You must select exactly `k` **distinct** non-empty subarrays `nums[l..r]`. Subarrays may overlap, but the exact same subarray (same `l` and `r`) cannot be chosen more than once.

The value of a subarray `nums[l..r]` is: `max(nums[l..r]) - min(nums[l..r])`.

Return the maximum possible total value (sum of values of all chosen subarrays).

## Examples

**Example 1**
```
Input:  nums = [1, 3, 2], k = 2
Output: 4
Explanation:
  - Choose nums[0..1] = [1,3]: value = 3-1 = 2
  - Choose nums[0..2] = [1,3,2]: value = 3-1 = 2
  Total = 4.
```

**Example 2**
```
Input:  nums = [4, 2, 5, 1], k = 3
Output: 12
Explanation:
  - nums[0..3]: value = 5-1 = 4
  - nums[1..3]: value = 5-1 = 4
  - nums[2..3]: value = 5-1 = 4
  Total = 12.
```

## Constraints

- `1 <= n == nums.length <= 5 * 10^4`
- `0 <= nums[i] <= 10^9`
- `1 <= k <= min(10^5, n * (n + 1) / 2)`
