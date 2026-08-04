# Find Missing Elements

**Difficulty:** Easy

## Problem Statement

You are given an integer array `nums` consisting of unique integers.

Originally, `nums` contained every integer within a certain range. However, some integers might have gone missing. The smallest and largest integers of the original range are still present in `nums`.

Return a sorted list of all the missing integers in this range. If no integers are missing, return an empty list.

## Examples

**Example 1**
```
Input:  nums = [1,4,2,5]
Output: [3]
Explanation: Range is [1,2,3,4,5]. Only 3 is missing.
```

**Example 2**
```
Input:  nums = [7,8,6,9]
Output: []
Explanation: Range is [6,7,8,9]. No integers are missing.
```

**Example 3**
```
Input:  nums = [5,1]
Output: [2,3,4]
Explanation: Range is [1,2,3,4,5]. Missing: 2, 3, 4.
```

## Constraints

- `2 <= nums.length <= 100`
- `1 <= nums[i] <= 100`
