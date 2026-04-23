# Divide Array Into Equal Pairs

**Difficulty:** Easy

## Problem Statement

You are given an integer array `nums` consisting of `2 * n` integers.

You need to divide `nums` into `n` pairs such that:

- Each element belongs to exactly one pair.
- The elements present in a pair are equal.

Return `true` if `nums` can be divided into `n` pairs, otherwise return `false`.

## Examples

**Example 1**
```
Input:  nums = [3, 2, 3, 2, 2, 2]
Output: true
Explanation: Divide into 3 pairs: (2,2), (3,3), and (2,2). All conditions are satisfied.
```

**Example 2**
```
Input:  nums = [1, 2, 3, 4]
Output: false
Explanation: There is no way to divide nums into 2 equal pairs.
```

## Constraints

- `nums.length == 2 * n`
- `1 <= n <= 500`
- `1 <= nums[i] <= 500`
