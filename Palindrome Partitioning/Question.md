# Combination Sum

**Difficulty:** Medium

## Problem Statement

Given an array of distinct integers `candidates` and a target integer `target`, return a list of all unique combinations of `candidates` where the chosen numbers sum to `target`. You may return the combinations in any order.

The same number may be chosen from `candidates` an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

## Examples

**Example 1**
```
Input:  candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation: 2+2+3=7 and 7=7 are the only two combinations.
```

**Example 2**
```
Input:  candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
```

**Example 3**
```
Input:  candidates = [2], target = 1
Output: []
```

## Constraints

- `1 <= candidates.length <= 30`
- `2 <= candidates[i] <= 40`
- All elements of `candidates` are distinct.
- `1 <= target <= 40`

---

# Palindrome Partitioning

**Difficulty:** Medium

## Problem Statement

Given a string `s`, partition `s` such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of `s`.

## Examples

**Example 1**
```
Input:  s = "aab"
Output: [["a","a","b"],["aa","b"]]
```

**Example 2**
```
Input:  s = "a"
Output: [["a"]]
```

## Constraints

- `1 <= s.length <= 16`
- `s` contains only lowercase English letters.
