# Minimum Number of Operations to Make String Alternating

**Difficulty:** Easy

## Problem Statement

You are given a string `s` consisting only of the characters `'0'` and `'1'`. In one operation, you can change any `'0'` to `'1'` or vice versa.

The string is called **alternating** if no two adjacent characters are equal. For example, `"010"` is alternating, while `"0100"` is not.

Return the minimum number of operations needed to make `s` alternating.

## Examples

**Example 1**
```
Input:  s = "0100"
Output: 1
Explanation: Change the last character to '1' → "0101", which is alternating.
```

**Example 2**
```
Input:  s = "10"
Output: 0
Explanation: s is already alternating.
```

**Example 3**
```
Input:  s = "1111"
Output: 2
Explanation: Two operations are needed to reach "0101" or "1010".
```

## Constraints

- `1 <= s.length <= 10^4`
- `s[i]` is either `'0'` or `'1'`.
