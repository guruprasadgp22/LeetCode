# Sum of Compatible Integers

**Difficulty:** Easy

## Problem Statement

You are given two integers `n` and `k`.

A positive integer `x` is called **compatible** if it satisfies both of the following conditions:

- `abs(n - x) <= k`
- `(n & x) == 0`

Return the sum of all compatible integers `x`.

**Note:** `&` denotes the bitwise AND operator.

## Examples

**Example 1**
```
Input:  n = 2, k = 3
Output: 10
Explanation:
  - x=1: |2-1|=1 ≤ 3 and 2&1=0 ✓
  - x=4: |2-4|=2 ≤ 3 and 2&4=0 ✓
  - x=5: |2-5|=3 ≤ 3 and 2&5=0 ✓
  Sum = 1 + 4 + 5 = 10.
```

**Example 2**
```
Input:  n = 5, k = 1
Output: 0
Explanation: No compatible integers exist in the range [4, 6].
```

## Constraints

- The problem constraints are as provided in the original problem statement.
