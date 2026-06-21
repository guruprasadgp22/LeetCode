# Maximum Building Height

**Difficulty:** Hard

## Problem Statement

You want to build `n` new buildings in a city, labeled from `1` to `n`, subject to the following rules:

- The height of each building must be a non-negative integer.
- The height of the first building must be `0`.
- The height difference between any two adjacent buildings cannot exceed `1`.

Additionally, specific buildings have maximum height restrictions given as `restrictions[i] = [idi, maxHeighti]`.

Return the maximum possible height of the tallest building.

## Examples

**Example 1**
```
Input:  n = 5, restrictions = [[2,1],[4,1]]
Output: 2
Explanation: Heights [0,1,2,1,2] are valid. Tallest = 2.
```

**Example 2**
```
Input:  n = 6, restrictions = []
Output: 5
Explanation: Heights [0,1,2,3,4,5] are valid. Tallest = 5.
```

**Example 3**
```
Input:  n = 10, restrictions = [[5,3],[2,5],[7,4],[10,3]]
Output: 5
Explanation: Heights [0,1,2,3,3,4,4,5,4,3] are valid. Tallest = 5.
```

## Constraints

- `2 <= n <= 10^9`
- `0 <= restrictions.length <= min(n - 1, 10^5)`
- `2 <= idi <= n`, each `idi` is unique.
- `0 <= maxHeighti <= 10^9`
