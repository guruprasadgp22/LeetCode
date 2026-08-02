# Stone Game

**Difficulty:** Medium

## Problem Statement

Alice and Bob play a game with piles of stones. There are an even number of piles in a row, and each pile has a positive integer number of stones `piles[i]`. The total stones is odd, so there are no ties.

Alice goes first. Each turn, a player takes the entire pile from either end of the row. The person with the most stones at the end wins.

Assuming both play optimally, return `true` if Alice wins, or `false` if Bob wins.

## Examples

**Example 1**
```
Input:  piles = [5,3,4,5]
Output: true
Explanation: Alice takes the first 5. No matter what Bob does, Alice can always win.
```

**Example 2**
```
Input:  piles = [3,7,2,3]
Output: true
```

## Constraints

- `2 <= piles.length <= 500`
- `piles.length` is even.
- `1 <= piles[i] <= 500`
- `sum(piles)` is odd.
