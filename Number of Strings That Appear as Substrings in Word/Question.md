# Number of Strings That Appear as Substrings in Word

**Difficulty:** Easy

## Problem Statement

Given an array of strings `patterns` and a string `word`, return the number of strings in `patterns` that exist as a substring in `word`.

## Examples

**Example 1**
```
Input:  patterns = ["a","abc","bc","d"], word = "abc"
Output: 3
Explanation:
  - "a" → substring of "abc" ✓
  - "abc" → substring of "abc" ✓
  - "bc" → substring of "abc" ✓
  - "d" → not a substring ✗
```

**Example 2**
```
Input:  patterns = ["a","b","c"], word = "aaaaabbbbb"
Output: 2
Explanation: "a" and "b" are substrings; "c" is not.
```

**Example 3**
```
Input:  patterns = ["a","a","a"], word = "ab"
Output: 3
Explanation: Each "a" appears as a substring in "ab".
```

## Constraints

- `1 <= patterns.length <= 100`
- `1 <= patterns[i].length <= 100`
- `1 <= word.length <= 100`
- `patterns[i]` and `word` consist of lowercase English letters.
