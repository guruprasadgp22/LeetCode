# 3841. Palindromic Path Queries in a Tree

**Difficulty:** Hard

## Problem

You are given an undirected tree with `n` nodes labeled 0 to `n - 1`. This is represented by a 2D array `edges` of length `n - 1`, where `edges[i] = [u_i, v_i]` indicates an undirected edge between nodes `u_i` and `v_i`.

You are also given a string `s` of length `n` consisting of lowercase English letters, where `s[i]` represents the character assigned to node `i`.

You are also given a string array `queries`, where each `queries[i]` is either:

- `"update u_i c"`: Change the character at node `u_i` to `c`. Formally, update `s[u_i] = c`.
- `"query u_i v_i"`: Determine whether the string formed by the characters on the unique path from `u_i` to `v_i` (inclusive) can be rearranged into a palindrome.

Return a boolean array `answer`, where `answer[j]` is `true` if the `j`th query of type `"query u_i v_i"` can be rearranged into a palindrome, and `false` otherwise.

## Examples

### Example 1

```
Input: n = 3, edges = [[0,1],[1,2]], s = "aac", queries = ["query 0 2","update 1 b","query 0 2"]
Output: [true,false]
```

**Explanation:**

- `"query 0 2"`: Path `0 → 1 → 2` gives `"aac"`, which can be rearranged to form `"aca"`, a palindrome. Thus, `answer[0] = true`.
- `"update 1 b"`: Update node 1 to `'b'`, now `s = "abc"`.
- `"query 0 2"`: Path characters are `"abc"`, which cannot be rearranged to form a palindrome. Thus, `answer[1] = false`.

Thus, `answer = [true, false]`.

### Example 2

```
Input: n = 4, edges = [[0,1],[0,2],[0,3]], s = "abca", queries = ["query 1 2","update 0 b","query 2 3","update 3 a","query 1 3"]
Output: [false,false,true]
```

**Explanation:**

- `"query 1 2"`: Path `1 → 0 → 2` gives `"bac"`, which cannot be rearranged to form a palindrome. Thus, `answer[0] = false`.
- `"update 0 b"`: Update node 0 to `'b'`, now `s = "bbca"`.
- `"query 2 3"`: Path `2 → 0 → 3` gives `"cba"`, which cannot be rearranged to form a palindrome. Thus, `answer[1] = false`.
- `"update 3 a"`: Update node 3 to `'a'`, `s = "bbca"`.
- `"query 1 3"`: Path `1 → 0 → 3` gives `"bba"`, which can be rearranged to form `"bab"`, a palindrome. Thus, `answer[2] = true`.

Thus, `answer = [false, false, true]`.

## Constraints

- `1 <= n == s.length <= 5 * 10^4`
- `edges.length == n - 1`
- `edges[i] = [u_i, v_i]`
- `0 <= u_i, v_i <= n - 1`
- `s` consists of lowercase English letters.
- The input is generated such that `edges` represents a valid tree.
- `1 <= queries.length <= 5 * 10^4`
  - `queries[i] = "update u_i c"` or
  - `queries[i] = "query u_i v_i"`
  - `0 <= u_i, v_i <= n - 1`
  - `c` is a lowercase English letter.
