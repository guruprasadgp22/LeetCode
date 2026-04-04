# Find the Difference of Two Arrays

**Difficulty:** Easy

## Problem Statement

Given two 0-indexed integer arrays `nums1` and `nums2`, return a list `answer` of size `2` where:

- `answer[0]` is a list of all distinct integers in `nums1` which are not present in `nums2`.
- `answer[1]` is a list of all distinct integers in `nums2` which are not present in `nums1`.

Note that the integers in the lists may be returned in any order.

## Examples

**Example 1**
```
Input:  nums1 = [1, 2, 3], nums2 = [2, 4, 6]
Output: [[1, 3], [4, 6]]
Explanation:
  - 1 and 3 from nums1 are not in nums2 → answer[0] = [1, 3]
  - 4 and 6 from nums2 are not in nums1 → answer[1] = [4, 6]
```

**Example 2**
```
Input:  nums1 = [1, 2, 3, 3], nums2 = [1, 1, 2, 2]
Output: [[3], []]
Explanation:
  - 3 from nums1 is not in nums2 (counted once) → answer[0] = [3]
  - Every integer in nums2 is present in nums1 → answer[1] = []
```

## Constraints

- `1 <= nums1.length, nums2.length <= 1000`
- `-1000 <= nums1[i], nums2[i] <= 1000`
