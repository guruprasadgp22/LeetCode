# Maximum Number of Non-Overlapping Substrings

**Difficulty:** Hard

## Problem Statement

Given a string `s` of lowercase letters, find the maximum number of non-empty substrings that meet the following conditions:

1. The substrings do not overlap — for any two substrings `s[i..j]` and `s[x..y]`, either `j < x` or `i > y`.
2. A substring that contains a certain character `c` must also contain **all** occurrences of `c`.

If there are multiple solutions with the same number of substrings, return the one with **minimum total length**. It can be shown that there exists a unique solution of minimum total length.

Return the substrings in any order.

## Examples

**Example 1**
```
Input:  s = "adefaddaccc"
Output: ["e","f","ccc"]
Explanation: The maximum is 3 non-overlapping substrings. Choosing "e", "f", and "ccc"
             gives 3 substrings with minimum total length.
```

**Example 2**
```
Input:  s = "abbaccd"
Output: ["d","bb","cc"]
Explanation: ["d","abba","cc"] also has 3 substrings but larger total length, so it's not optimal.
```

## Constraints

- `1 <= s.length <= 10^5`
- `s` contains only lowercase English letters.
