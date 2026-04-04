# Maximum Difference Between Odd and Even Frequency

**Difficulty:** Easy

## Problem Statement

You are given a string `s` consisting of lowercase English letters.

Your task is to find the maximum difference `diff = freq(a1) - freq(a2)` between the frequency of characters `a1` and `a2` in the string such that:

- `a1` has an **odd** frequency in the string.
- `a2` has an **even** frequency in the string.

Return this maximum difference.

## Examples

**Example 1**
```
Input:  s = "aaaaabbc"
Output: 3
Explanation:
  - 'a' has an odd frequency of 5.
  - 'b' has an even frequency of 2.
  - Maximum difference = 5 - 2 = 3.
```

**Example 2**
```
Input:  s = "abcabcab"
Output: 1
Explanation:
  - 'a' has an odd frequency of 3.
  - 'c' has an even frequency of 2.
  - Maximum difference = 3 - 2 = 1.
```

## Constraints

- `3 <= s.length <= 100`
- `s` consists only of lowercase English letters.
- `s` contains at least one character with an odd frequency and one with an even frequency.
