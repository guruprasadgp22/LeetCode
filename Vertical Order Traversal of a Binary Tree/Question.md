# 987. Vertical Order Traversal of a Binary Tree

**Solved**  
**Hard**

## Topics
- Binary Tree
- Depth-First Search
- Breadth-First Search
- Hash Table
- Sorting
- Tree
- Binary Search Tree

## Companies
> Premium content on LeetCode

---

Given the `root` of a binary tree, calculate the **vertical order traversal** of the binary tree.

For each node at position `(row, col)`, its left and right children will be at positions:
- Left child → `(row + 1, col - 1)`
- Right child → `(row + 1, col + 1)`

The root of the tree is at `(0, 0)`.

The **vertical order traversal** of a binary tree is a list of **top-to-bottom orderings** for each column index starting from the **leftmost column** and ending on the **rightmost column**.

There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

---

## Example 1
![Example 1](https://assets.leetcode.com/uploads/2019/01/30/tree1.png)

**Input:**  
```text
root = [3,9,20,null,null,15,7]
```
**Output:**

```text
[[9],[3,15],[20],[7]]
```

## Explanation:

```
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.
```
## Example 2
![Example 1](https://assets.leetcode.com/uploads/2021/01/29/vtree2.jpg)

**Input:**
```text
root = [1,2,3,4,5,6,7]
```
**Output:**
```text
[[4],[2],[1,5,6],[3],[7]]
```
## Explanation:
```
Column -2: Only node 4
Column -1: Only node 2
Column 0: Nodes 1, 5, and 6
Column 1: Only node 3
Column 2: Only node 7
```
---
