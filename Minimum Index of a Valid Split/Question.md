# Minimum Index of a Valid Split

**Difficulty:** Medium

## Problem Statement

An element `x` of an integer array `arr` of length `m` is **dominant** if more than half the elements of `arr` have a value of `x`.

You are given a 0-indexed integer array `nums` of length `n` with one dominant element.

You can split `nums` at an index `i` into two arrays `nums[0, ..., i]` and `nums[i + 1, ..., n - 1]`, but the split is only valid if:

- `0 <= i < n - 1`
- Both `nums[0, ..., i]` and `nums[i + 1, ..., n - 1]` have the same dominant element.

Return the minimum index of a valid split. If no valid split exists, return `-1`.

## Examples

**Example 1**
```
Input:  nums = [1, 2, 2, 2]
Output: 2
Explanation: Split at index 2 → [1,2,2] and [2].
  - In [1,2,2]: 2 occurs twice and 2*2 > 3 ✓
  - In [2]: 2 occurs once and 1*2 > 1 ✓
  Index 2 is the minimum valid split index.
```

**Example 2**
```
Input:  nums = [2, 1, 3, 1, 1, 1, 7, 1, 2, 1]
Output: 4
Explanation: Split at index 4 → [2,1,3,1,1] and [1,7,1,2,1].
  - In [2,1,3,1,1]: 1 occurs 3 times and 3*2 > 5 ✓
  - In [1,7,1,2,1]: 1 occurs 3 times and 3*2 > 5 ✓
```

**Example 3**
```
Input:  nums = [3, 3, 3, 3, 7, 2, 2]
Output: -1
Explanation: There is no valid split.
```

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
- `nums` has exactly one dominant element.
