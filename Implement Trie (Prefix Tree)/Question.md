# Implement Trie (Prefix Tree)

**Difficulty:** Medium

## Problem Statement

A trie (pronounced "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. Applications include autocomplete and spellchecker.

Implement the `Trie` class:

- `Trie()` — Initializes the trie object.
- `void insert(String word)` — Inserts the string `word` into the trie.
- `boolean search(String word)` — Returns `true` if `word` is in the trie, and `false` otherwise.
- `boolean startsWith(String prefix)` — Returns `true` if there is a previously inserted word that has the prefix `prefix`, and `false` otherwise.

## Example

```
Input:
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]

Output:
[null, null, true, false, true, null, true]

Explanation:
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return true
trie.search("app");     // return false
trie.startsWith("app"); // return true
trie.insert("app");
trie.search("app");     // return true
```

## Constraints

- `1 <= word.length, prefix.length <= 2000`
- `word` and `prefix` consist only of lowercase English letters.
- At most `3 * 10^4` calls in total will be made to `insert`, `search`, and `startsWith`.
