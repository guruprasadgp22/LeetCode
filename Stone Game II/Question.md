# Stone Game II

**Difficulty:** Medium

## Problem Statement

Alice and Bob play a game with piles of stones arranged in a row. The objective is to end with the most stones.

Alice goes first. On each player's turn, that player can take all the stones in the first `X` remaining piles, where `1 <= X <= 2M`. Then set `M = max(M, X)`. Initially, `M = 1`.

Assuming both play optimally, return the maximum number of stones Alice can get.

## Examples

**Example 1**
```
Input:  piles = [2,7,9,4,4]
Output: 10
Explanation:
  - Alice takes 1 pile (2), Bob takes 2 piles (7,9), Alice takes 2 piles (4,4) → Alice = 10.
  - If Alice takes 2 piles (2,7), Bob can take all 3 remaining → Alice = 9.
  Best = 10.
```

**Example 2**
```
Input:  piles = [1,2,3,4,5,100]
Output: 104
```

## Constraints

- `1 <= piles.length <= 100`
- `1 <= piles[i] <= 10^4`
