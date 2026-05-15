# Binary Search Tree Iterator

**Difficulty:** Medium

## Problem Statement

Implement the `BSTIterator` class that represents an iterator over the in-order traversal of a binary search tree (BST):

- `BSTIterator(TreeNode root)` — Initializes the object. The pointer is initialized to a non-existent number smaller than any element in the BST.
- `boolean hasNext()` — Returns `true` if there exists a number to the right of the pointer, otherwise returns `false`.
- `int next()` — Moves the pointer to the right, then returns the number at the pointer.

The first call to `next()` will return the smallest element in the BST.

You may assume that `next()` calls will always be valid.

## Example

```
Input:
["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[[[7,3,15,null,null,9,20]], [], [], [], [], [], [], [], [], []]

Output:
[null, 3, 7, true, 9, true, 15, true, 20, false]

Explanation:
BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
bSTIterator.next();    // return 3
bSTIterator.next();    // return 7
bSTIterator.hasNext(); // return true
bSTIterator.next();    // return 9
bSTIterator.hasNext(); // return true
bSTIterator.next();    // return 15
bSTIterator.hasNext(); // return true
bSTIterator.next();    // return 20
bSTIterator.hasNext(); // return false
```

## Constraints

- The number of nodes in the tree is in the range `[1, 10^5]`.
- `0 <= Node.val <= 10^6`
- At most `10^5` calls will be made to `hasNext` and `next`.
