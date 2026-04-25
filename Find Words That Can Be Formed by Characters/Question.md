# Find Words That Can Be Formed by Characters

**Difficulty:** Easy

## Problem Statement

You are given an array of strings `words` and a string `chars`.

A string is **good** if it can be formed by characters from `chars` (each character can only be used once for each word in `words`).

Return the sum of lengths of all good strings in `words`.

## Examples

**Example 1**
```
Input:  words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: "cat" and "hat" can be formed from chars. Sum = 3 + 3 = 6.
```

**Example 2**
```
Input:  words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation: "hello" and "world" can be formed from chars. Sum = 5 + 5 = 10.
```

## Constraints

- `1 <= words.length <= 1000`
- `1 <= words[i].length, chars.length <= 100`
- `words[i]` and `chars` consist of lowercase English letters.
