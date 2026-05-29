# Insert Delete GetRandom O(1)

**Difficulty:** Medium

## Problem Statement

Implement the `RandomizedSet` class:

- `RandomizedSet()` — Initializes the `RandomizedSet` object.
- `bool insert(int val)` — Inserts `val` into the set if not present. Returns `true` if the item was not present, `false` otherwise.
- `bool remove(int val)` — Removes `val` from the set if present. Returns `true` if the item was present, `false` otherwise.
- `int getRandom()` — Returns a random element from the current set. Each element must have the same probability of being returned.

Each function must work in average `O(1)` time complexity.

## Example

```
Input:
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]

Output:
[null, true, false, true, 2, true, false, 2]

Explanation:
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1);    // returns true (1 inserted)
randomizedSet.remove(2);    // returns false (2 not in set)
randomizedSet.insert(2);    // returns true (2 inserted), set = [1,2]
randomizedSet.getRandom();  // returns 1 or 2 randomly
randomizedSet.remove(1);    // returns true (1 removed), set = [2]
randomizedSet.insert(2);    // returns false (2 already in set)
randomizedSet.getRandom();  // returns 2 (only element)
```

## Constraints

- `-2^31 <= val <= 2^31 - 1`
- At most `2 * 10^5` calls will be made to `insert`, `remove`, and `getRandom`.
- There will be at least one element in the data structure when `getRandom` is called.
