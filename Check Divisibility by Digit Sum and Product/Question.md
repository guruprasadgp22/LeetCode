# Check Divisibility by Digit Sum and Product

**Difficulty:** Easy

## Problem Statement

You are given a positive integer `n`. Determine whether `n` is divisible by the sum of:

- The **digit sum** of `n` (sum of its digits).
- The **digit product** of `n` (product of its digits).

Return `true` if `n` is divisible by this combined value; otherwise return `false`.

## Examples

**Example 1**
```
Input:  n = 99
Output: true
Explanation: Digit sum = 9+9 = 18, digit product = 9*9 = 81. Total = 99. 99 % 99 = 0 ✓
```

**Example 2**
```
Input:  n = 23
Output: false
Explanation: Digit sum = 2+3 = 5, digit product = 2*3 = 6. Total = 11. 23 % 11 ≠ 0 ✗
```

## Constraints

- `1 <= n <= 10^6`
