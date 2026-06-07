# Minimum Energy for Light Bulbs

**Difficulty:** Medium

## Problem Statement

You are given an integer `n`, representing `n` light bulbs arranged in a line and indexed from `0` to `n - 1`.

You are also given an integer `brightness` and a 2D integer array `intervals`, where `intervals[i] = [starti, endi]` represents an inclusive time interval during which the lighting requirement must be satisfied.

At each time unit, every bulb can independently be either on or off. A bulb that is on illuminates its own position and its adjacent positions (if they exist). The total illumination is the number of illuminated positions (each counted at most once).

For every time unit covered by at least one interval, the total illumination must be at least `brightness`. Each bulb that is on consumes 1 unit of energy per time unit.

Return the minimum total energy required.

## Examples

**Example 1**
```
Input:  n = 5, brightness = 5, intervals = [[6,12]]
Output: 14
Explanation: Turn on bulbs at positions 1 and 4 (state: 0 1 0 0 1).
             All 5 positions are illuminated.
             Interval length = 12 - 6 + 1 = 7, total energy = 2 * 7 = 14.
```

**Example 2**
```
Input:  n = 2, brightness = 1, intervals = [[0,0],[2,2]]
Output: 2
Explanation: Turn on one bulb during each interval. Each has length 1.
             Total energy = 1 * 2 = 2.
```

**Example 3**
```
Input:  n = 4, brightness = 2, intervals = [[1,3],[2,4]]
Output: 4
Explanation: One bulb can illuminate 2+ positions.
             Overlapping intervals cover [1,4] with length 4.
             Total energy = 1 * 4 = 4.
```

## Constraints

- `1 <= n <= 10^6`
- `1 <= brightness <= n`
- `1 <= intervals.length <= 10^5`
- `0 <= starti <= endi <= 10^9`
