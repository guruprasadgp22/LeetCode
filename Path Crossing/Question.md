# Circular Sentence

**Difficulty:** Easy

## Problem Statement

A sentence is a list of words separated by a single space with no leading or trailing spaces. Words consist of only uppercase and lowercase English letters.

A sentence is **circular** if:

- The last character of each word is equal to the first character of its next word.
- The last character of the last word is equal to the first character of the first word.

Given a string `sentence`, return `true` if it is circular. Otherwise, return `false`.

## Examples

**Example 1**
```
Input:  sentence = "leetcode exercises sound delightful"
Output: true
Explanation:
  - leetcode's last char == exercises's first char ✓
  - exercises's last char == sound's first char ✓
  - sound's last char == delightful's first char ✓
  - delightful's last char == leetcode's first char ✓
```

**Example 2**
```
Input:  sentence = "eetcode"
Output: true
Explanation: eetcode's last character equals its first character.
```

**Example 3**
```
Input:  sentence = "Leetcode is cool"
Output: false
Explanation: Leetcode's last character is not equal to is's first character.
```

## Constraints

- `1 <= sentence.length <= 500`
- `sentence` consists of only lowercase and uppercase English letters and spaces.
- Words are separated by a single space with no leading or trailing spaces.

---

# Path Crossing

**Difficulty:** Easy

## Problem Statement

Given a string `path`, where `path[i] = 'N'`, `'S'`, `'E'` or `'W'`, each representing moving one unit north, south, east, or west, respectively. You start at the origin `(0, 0)` on a 2D plane and walk on the path specified by `path`.

Return `true` if the path crosses itself at any point, that is, if at any time you are on a location you have previously visited. Return `false` otherwise.

## Examples

**Example 1**
```
Input:  path = "NES"
Output: false
Explanation: The path doesn't cross any point more than once.
```

**Example 2**
```
Input:  path = "NESWW"
Output: true
Explanation: The path visits the origin twice.
```

## Constraints

- `1 <= path.length <= 10^4`
- `path[i]` is either `'N'`, `'S'`, `'E'`, or `'W'`.
