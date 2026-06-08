# String Compression

**Difficulty:** Medium

## Problem Statement

Given an array of characters `chars`, compress it using the following algorithm:

Begin with an empty string `s`. For each group of consecutive repeating characters in `chars`:

- If the group's length is `1`, append the character to `s`.
- Otherwise, append the character followed by the group's length.

The compressed string `s` should be stored in-place in `chars`. Note that group lengths of `10` or more will be split into multiple characters.

After modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.

## Examples

**Example 1**
```
Input:  chars = ["a","a","b","b","c","c","c"]
Output: 6
Explanation: Groups are "aa", "bb", "ccc" → compresses to "a2b2c3".
             First 6 characters: ["a","2","b","2","c","3"].
```

**Example 2**
```
Input:  chars = ["a"]
Output: 1
Explanation: Single character stays uncompressed. Result: ["a"].
```

**Example 3**
```
Input:  chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: 4
Explanation: Groups are "a" and "bbbbbbbbbbbb" → compresses to "ab12".
             First 4 characters: ["a","b","1","2"].
```

## Constraints

- `1 <= chars.length <= 2000`
- `chars[i]` is a lowercase English letter, uppercase English letter, digit, or symbol.
