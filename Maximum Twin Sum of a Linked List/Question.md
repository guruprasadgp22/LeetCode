# Maximum Twin Sum of a Linked List

**Difficulty:** Medium

## Problem Statement

In a linked list of size `n` (where `n` is even), the `ith` node (0-indexed) is the twin of the `(n-1-i)th` node, for `0 <= i <= (n / 2) - 1`.

The twin sum is defined as the sum of a node and its twin.

Given the `head` of a linked list with even length, return the maximum twin sum of the linked list.

## Examples

**Example 1**
```
Input:  head = [5, 4, 2, 1]
Output: 6
Explanation: Node 0 twins node 3 (5+1=6), node 1 twins node 2 (4+2=6). Max = 6.
```

**Example 2**
```
Input:  head = [4, 2, 2, 3]
Output: 7
Explanation: Node 0 twins node 3 (4+3=7), node 1 twins node 2 (2+2=4). Max = 7.
```

**Example 3**
```
Input:  head = [1, 100000]
Output: 100001
Explanation: Only one twin pair: 1 + 100000 = 100001.
```

## Constraints

- The number of nodes is an even integer in the range `[2, 10^5]`.
- `1 <= Node.val <= 10^5`
