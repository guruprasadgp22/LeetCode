# Stone Game III

**Difficulty:** Hard

## Problem Statement

Alice and Bob play a game with stones arranged in a row, each with an integer value in the array `stoneValue`.

Alice goes first. On each turn, a player can take `1`, `2`, or `3` stones from the beginning of the remaining row. Each player's score is the sum of the values of stones taken. Both play optimally.

Return `"Alice"` if Alice wins, `"Bob"` if Bob wins, or `"Tie"` if they end with the same score.

## Examples

**Example 1**
```
Input:  stoneValue = [1,2,3,7]
Output: "Bob"
Explanation: Alice's best move is to take 3 stones (score=6), but Bob takes 7 and wins.
```

**Example 2**
```
Input:  stoneValue = [1,2,3,-9]
Output: "Alice"
Explanation: Alice takes all 3 first stones (score=6), leaving Bob with -9. Alice wins.
```

**Example 3**
```
Input:  stoneValue = [1,2,3,6]
Output: "Tie"
Explanation: Alice takes 3 stones (score=6), Bob takes 6 — but optimal play leads to a draw.
```

## Constraints

- `1 <= stoneValue.length <= 5 * 10^4`
- `-1000 <= stoneValue[i] <= 1000`
