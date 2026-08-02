# Predict the Winner

**Difficulty:** Medium

## Problem Statement

You are given an integer array `nums`. Two players are playing a game: player 1 and player 2.

Player 1 goes first. Both start with a score of `0`. At each turn, the current player takes one number from either end of the array (`nums[0]` or `nums[nums.length - 1]`), adding it to their score. The game ends when the array is empty.

Return `true` if Player 1 can win. If scores are equal, Player 1 is still the winner (return `true`). Both players play optimally.

## Examples

**Example 1**
```
Input:  nums = [1,5,2]
Output: false
Explanation: No matter how Player 1 plays, Player 2 can always score 5.
             Best case: Player 1 = 1+2 = 3, Player 2 = 5. Player 1 loses.
```

**Example 2**
```
Input:  nums = [1,5,233,7]
Output: true
Explanation: Player 1 picks 1 first, then can always pick 233.
             Final: Player 1 = 234, Player 2 = 12. Player 1 wins.
```

## Constraints

- `1 <= nums.length <= 20`
- `0 <= nums[i] <= 10^7`
