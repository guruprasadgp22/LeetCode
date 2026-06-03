# Theme Park Rides

**Difficulty:** Medium

## Problem Statement

You are given two categories of theme park attractions: land rides and water rides.

- **Land rides:** `landStartTime[i]` is the earliest boarding time and `landDuration[i]` is how long the ride lasts.
- **Water rides:** `waterStartTime[j]` is the earliest boarding time and `waterDuration[j]` is how long the ride lasts.

A tourist must experience exactly one ride from each category, in either order.

- A ride may be started at its opening time or any later moment.
- If a ride starts at time `t`, it finishes at time `t + duration`.
- Immediately after finishing one ride, the tourist may board the next (if already open) or wait.

Return the earliest possible time at which the tourist can finish both rides.

## Examples

**Example 1**
```
Input:  landStartTime = [2,8], landDuration = [4,1], waterStartTime = [6], waterDuration = [3]
Output: 9
Explanation:
  Best plan — land ride 0 → water ride 0:
  - Start land ride 0 at t=2, finish at t=6.
  - Water ride 0 opens at t=6, start immediately, finish at t=9.
```

**Example 2**
```
Input:  landStartTime = [5], landDuration = [3], waterStartTime = [1], waterDuration = [10]
Output: 14
Explanation:
  Best plan — water ride 0 → land ride 0:
  - Start water ride 0 at t=1, finish at t=11.
  - Land ride 0 opened at t=5, start at t=11, finish at t=14.
```

## Constraints

- `1 <= n, m <= 5 * 10^4`
- `landStartTime.length == landDuration.length == n`
- `waterStartTime.length == waterDuration.length == m`
- `1 <= landStartTime[i], landDuration[i], waterStartTime[j], waterDuration[j] <= 10^5`
