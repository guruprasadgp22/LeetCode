# Kth Distinct String in an Array

**Difficulty:** Easy

## Problem Statement

A distinct string is a string that is present only once in an array.

Given an array of strings `arr`, and an integer `k`, return the `kth` distinct string present in `arr`. If there are fewer than `k` distinct strings, return an empty string `""`.

Note that the strings are considered in the order in which they appear in the array.

## Examples

**Example 1**
```
Input:  arr = ["d","b","c","b","c","a"], k = 2
Output: "a"
Explanation: The distinct strings are "d" (1st) and "a" (2nd).
             Since k=2, we return "a".
```

**Example 2**
```
Input:  arr = ["aaa","aa","a"], k = 1
Output: "aaa"
Explanation: All strings are distinct. The 1st distinct string is "aaa".
```

**Example 3**
```
Input:  arr = ["a","b","a"], k = 3
Output: ""
Explanation: The only distinct string is "b".
             Since there are fewer than 3 distinct strings, return "".
```

## Constraints

- `1 <= k <= arr.length <= 1000`
- `1 <= arr[i].length <= 5`
- `arr[i]` consists of lowercase English letters.
