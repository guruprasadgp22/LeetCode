# Longest Subarray of 1's After Deleting One Element

**Difficulty:** Medium

## Problem Statement

Given a binary array `nums`, you should delete one element from it.

Return the size of the longest non-empty subarray containing only `1`'s in the resulting array. Return `0` if there is no such subarray.

## Examples

**Example 1**
```
Input:  nums = [1,1,0,1]
Output: 3
Explanation: Delete position 2 → [1,1,1], which contains 3 ones.
```

**Example 2**
```
Input:  nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: Delete position 4 → longest subarray of 1s has length 5.
```

**Example 3**
```
Input:  nums = [1,1,1]
Output: 2
Explanation: You must delete one element, leaving at most 2 ones.
```

## Constraints

- `1 <= nums.length <= 10^5`
- `nums[i]` is either `0` or `1`.

---

# Maximum Value After Operations

**Difficulty:** Medium

## Problem Statement

You are given an array of positive integers `arr`. Perform some operations (possibly none) so that:

- The first element in `arr` must be `1`.
- The absolute difference between any 2 adjacent elements must be ≤ 1.

You can: decrease any element to a smaller positive integer, or rearrange the elements in any order.

Return the maximum possible value of any element in `arr` after performing these operations.

## Examples

**Example 1**
```
Input:  arr = [2,2,1,2,1]
Output: 2
Explanation: Rearrange to [1,2,2,2,1]. Largest element = 2.
```

**Example 2**
```
Input:  arr = [100,1,1000]
Output: 3
Explanation: Rearrange to [1,100,1000], then reduce to [1,2,3]. Largest = 3.
```

**Example 3**
```
Input:  arr = [1,2,3,4,5]
Output: 5
Explanation: Array already satisfies conditions. Largest = 5.
```

## Constraints

- `1 <= arr.length <= 10^5`
- `1 <= arr[i] <= 10^9`
