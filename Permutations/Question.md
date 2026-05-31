# Subsets

**Difficulty:** Medium

## Problem Statement

Given an integer array `nums` of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

## Examples

**Example 1**
```
Input:  nums = [1, 2, 3]
Output: [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]
```

**Example 2**
```
Input:  nums = [0]
Output: [[], [0]]
```

## Constraints

- `1 <= nums.length <= 10`
- `-10 <= nums[i] <= 10`
- All the numbers of `nums` are unique.

---

# Permutations

**Difficulty:** Medium

## Problem Statement

Given an array `nums` of distinct integers, return all the possible permutations. You can return the answer in any order.

## Examples

**Example 1**
```
Input:  nums = [1, 2, 3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
```

**Example 2**
```
Input:  nums = [0, 1]
Output: [[0,1],[1,0]]
```

**Example 3**
```
Input:  nums = [1]
Output: [[1]]
```

## Constraints

- `1 <= nums.length <= 6`
- `-10 <= nums[i] <= 10`
- All the integers of `nums` are unique.
