# Score of a Number

**Difficulty:** Easy

## Problem Statement

You are given an integer `n`.

The score of `n` is defined as the sum of `d * freq(d)` over all distinct digits `d`, where `freq(d)` denotes the number of times the digit `d` appears in `n`.

Return an integer denoting the score of `n`.

## Examples

**Example 1**
```
Input:  n = 122
Output: 5
Explanation:
  - Digit 1 appears 1 time → 1 * 1 = 1
  - Digit 2 appears 2 times → 2 * 2 = 4
  - Score = 1 + 4 = 5
```

**Example 2**
```
Input:  n = 101
Output: 2
Explanation:
  - Digit 0 appears 1 time → 0 * 1 = 0
  - Digit 1 appears 2 times → 1 * 2 = 2
  - Score = 0 + 2 = 2
```

## Constraints

- `1 <= n <= 10^9`
