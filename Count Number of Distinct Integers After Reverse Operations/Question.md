# Distinct Integers After Reversing and Adding

**Difficulty:** Easy

## Problem Statement

You are given an array `nums` consisting of positive integers.

You have to take each integer in the array, reverse its digits, and add it to the end of the array. You should apply this operation to the original integers in `nums`.

Return the number of distinct integers in the final array.

## Examples

**Example 1**
```
Input:  nums = [1, 13, 10, 12, 31]
Output: 6
Explanation: After reversing each number and appending, the array becomes:
             [1, 13, 10, 12, 31, 1, 31, 1, 21, 13]
             Note: reversing 10 gives 01 = 1.
             The distinct integers are: 1, 10, 12, 13, 21, 31 → count = 6.
```

**Example 2**
```
Input:  nums = [2, 2, 2]
Output: 1
Explanation: After reversing, the array becomes [2, 2, 2, 2, 2, 2].
             The only distinct integer is 2.
```

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^6`
