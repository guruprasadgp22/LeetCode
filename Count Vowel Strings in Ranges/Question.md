# Count Vowel Strings in Ranges

**Difficulty:** Medium

## Problem Statement

You are given a 0-indexed array of strings `words` and a 2D array of integers `queries`.

Each query `queries[i] = [li, ri]` asks us to find the number of strings present at the indices ranging from `li` to `ri` (both inclusive) of `words` that start and end with a vowel.

Return an array `ans` of size `queries.length`, where `ans[i]` is the answer to the `ith` query.

Note that the vowel letters are `'a'`, `'e'`, `'i'`, `'o'`, and `'u'`.

## Examples

**Example 1**
```
Input:  words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
Output: [2, 3, 0]
Explanation:
  Strings starting and ending with a vowel: "aba", "ece", "aa", "e"
  - Query [0,2]: "aba" and "ece" → 2
  - Query [1,4]: "ece", "aa", "e" → 3
  - Query [1,1]: "bcb" → 0
```

**Example 2**
```
Input:  words = ["a","e","i"], queries = [[0,2],[0,1],[2,2]]
Output: [3, 2, 1]
Explanation: Every string satisfies the conditions.
```

## Constraints

- `1 <= words.length <= 10^5`
- `1 <= words[i].length <= 40`
- `words[i]` consists only of lowercase English letters.
- `sum(words[i].length) <= 3 * 10^5`
- `1 <= queries.length <= 10^5`
- `0 <= li <= ri < words.length`
