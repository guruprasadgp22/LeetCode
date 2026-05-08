# Time Needed to Buy Tickets

**Difficulty:** Easy

## Problem Statement

There are `n` people in a line queuing to buy tickets, where the `0th` person is at the front and the `(n-1)th` person is at the back.

You are given a 0-indexed integer array `tickets` of length `n` where `tickets[i]` is the number of tickets the `ith` person wants to buy.

Each person takes exactly 1 second to buy a ticket and can only buy 1 ticket at a time. After buying, they go to the back of the line. If a person has no tickets left to buy, they leave the line.

Return the time taken for the person at position `k` (0-indexed) to finish buying all their tickets.

## Examples

**Example 1**
```
Input:  tickets = [2, 3, 2], k = 2
Output: 6
Explanation:
  t=0: queue = [2, 3, 2] (kth person underlined: index 2)
  t=1: queue = [3, 2, 1]
  t=2: queue = [2, 1, 2]
  t=3: queue = [1, 2, 1]
  t=4: queue = [2, 1]     (front person left)
  t=5: queue = [1, 1]
  t=6: queue = [1]        (kth person finished, return 6)
```

**Example 2**
```
Input:  tickets = [5, 1, 1, 1], k = 0
Output: 8
Explanation: The kth person at index 0 needs 5 rounds. Total time = 8 seconds.
```

## Constraints

- `n == tickets.length`
- `1 <= n <= 100`
- `1 <= tickets[i] <= 100`
- `0 <= k < n`
