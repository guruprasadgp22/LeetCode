# Delete the Middle Node of a Linked List

**Difficulty:** Medium

## Problem Statement

You are given the `head` of a linked list. Delete the middle node and return the `head` of the modified linked list.

The middle node of a linked list of size `n` is the `⌊n / 2⌋th` node from the start (0-based indexing).

- For `n = 1, 2, 3, 4, 5`, the middle nodes are at indices `0, 1, 1, 2, 2` respectively.

## Examples

**Example 1**
```
Input:  head = [1,3,4,7,1,2,6]
Output: [1,3,4,1,2,6]
Explanation: n=7, middle is index 3 (value 7). Remove it.
```

**Example 2**
```
Input:  head = [1,2,3,4]
Output: [1,2,4]
Explanation: n=4, middle is index 2 (value 3). Remove it.
```

**Example 3**
```
Input:  head = [2,1]
Output: [2]
Explanation: n=2, middle is index 1 (value 1). Remove it.
```

## Constraints

- The number of nodes is in the range `[1, 10^5]`.
- `1 <= Node.val <= 10^5`

---

# Process String with Special Characters

**Difficulty:** Easy

## Problem Statement

You are given a string `s` consisting of lowercase English letters and the special characters `*`, `#`, and `%`.

Build a new string `result` by processing `s` from left to right:

- **Lowercase letter** → append it to `result`.
- **`*`** → remove the last character from `result` (if it exists).
- **`#`** → duplicate `result` and append it to itself.
- **`%`** → reverse `result`.

Return the final string `result`.

## Examples

**Example 1**
```
Input:  s = "a#b%*"
Output: "ba"
Explanation:
  'a' → "a"
  '#' → "aa"
  'b' → "aab"
  '%' → "baa"
  '*' → "ba"
```

**Example 2**
```
Input:  s = "z*#"
Output: ""
Explanation:
  'z' → "z"
  '*' → ""
  '#' → ""
```

## Constraints

- `1 <= s.length <= 20`
- `s` consists of only lowercase English letters and special characters `*`, `#`, and `%`.
