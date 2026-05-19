# Minimum Number of Operations to Move All Balls to Each Box

**Difficulty:** Medium

## Problem Statement

You have `n` boxes. You are given a binary string `boxes` of length `n`, where `boxes[i]` is `'0'` if the `ith` box is empty, and `'1'` if it contains one ball.

In one operation, you can move one ball from a box to an adjacent box. Box `i` is adjacent to box `j` if `abs(i - j) == 1`.

Return an array `answer` of size `n`, where `answer[i]` is the minimum number of operations needed to move all the balls to the `ith` box.

Each `answer[i]` is calculated considering the initial state of the boxes.

## Examples

**Example 1**
```
Input:  boxes = "110"
Output: [1, 1, 3]
Explanation:
  - Box 0: move 1 ball from box 1 → 1 operation.
  - Box 1: move 1 ball from box 0 → 1 operation.
  - Box 2: move 1 ball from box 0 (2 ops) + 1 ball from box 1 (1 op) = 3 operations.
```

**Example 2**
```
Input:  boxes = "001011"
Output: [11, 8, 5, 4, 3, 4]
```

## Constraints

- `n == boxes.length`
- `1 <= n <= 2000`
- `boxes[i]` is either `'0'` or `'1'`.
