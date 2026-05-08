# Special Array With X Elements Greater Than or Equal X

**Difficulty:** Easy

## Problem Statement

You are given an array `nums` of non-negative integers. `nums` is considered **special** if there exists a number `x` such that there are exactly `x` numbers in `nums` that are greater than or equal to `x`.

Note that `x` does not have to be an element in `nums`.

Return `x` if the array is special, otherwise return `-1`. It can be proven that if `nums` is special, the value for `x` is unique.

## Examples

**Example 1**
```
Input:  nums = [3, 5]
Output: 2
Explanation: There are 2 values (3 and 5) that are >= 2.
```

**Example 2**
```
Input:  nums = [0, 0]
Output: -1
Explanation: No value of x satisfies the condition.
  - x=0: 2 numbers >= 0, but need 0 ✗
  - x=1: 0 numbers >= 1, but need 1 ✗
  - x=2: 0 numbers >= 2, but need 2 ✗
```

**Example 3**
```
Input:  nums = [0, 4, 3, 0, 4]
Output: 3
Explanation: There are 3 values that are >= 3.
```

## Constraints

- `1 <= nums.length <= 100`
- `0 <= nums[i] <= 1000`
