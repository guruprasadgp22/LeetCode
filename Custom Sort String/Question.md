# Custom Sort String

**Difficulty:** Medium

## Problem Statement

You are given two strings `order` and `s`. All the characters of `order` are unique and were sorted in some custom order previously.

Permute the characters of `s` so that they match the order that `order` was sorted. More specifically, if a character `x` occurs before a character `y` in `order`, then `x` should occur before `y` in the permuted string.

Return any permutation of `s` that satisfies this property.

## Examples

**Example 1**
```
Input:  order = "cba", s = "abcd"
Output: "cbad"
Explanation: 'a', 'b', 'c' follow the order "c", "b", "a".
             'd' is not in order so it can appear anywhere.
             "dcba", "cdba", "cbda" are also valid.
```

**Example 2**
```
Input:  order = "bcafg", s = "abcd"
Output: "bcad"
Explanation: 'b', 'c', 'a' follow the order from order.
             'd' is not in order so its position is flexible.
             "dbca" or "bcda" would also be valid.
```

## Constraints

- `1 <= order.length <= 26`
- `1 <= s.length <= 200`
- `order` and `s` consist of lowercase English letters.
- All the characters of `order` are unique.
