# 1385. Find the Distance Value Between Two Arrays

**Difficulty:** Easy

## Problem

You are given two integer arrays `arr1` and `arr2`, and an integer `d`.

An element `arr1[i]` is called far when every element `arr2[j]` satisfies `|arr1[i] - arr2[j]| > d`. In other words, no element of `arr2` lies within distance `d` of it.

Return the distance value, which is the number of far elements in `arr1`.

## Examples

### Example 1

```
Input: arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
Output: 2
```

**Explanation:**

- 4 is far. Its nearest value in `arr2` is 1, and `|4 - 1| = 3`, which is greater than `d = 2`.
- 5 is far. Its nearest value in `arr2` is 8, and `|5 - 8| = 3`, which is greater than `d = 2`.
- 8 is not far, because `|8 - 8| = 0` is at most `d = 2`.
- Two elements are far, so the distance value is 2.

### Example 2

```
Input: arr1 = [1,4,2,3], arr2 = [-4,-3,6,10,20,30], d = 3
Output: 2
```

**Explanation:**

- 1 is far. Its nearest value in `arr2` is -3, and `|1 - (-3)| = 4`, which is greater than `d = 3`.
- 2 is far. Its nearest value in `arr2` is 6, and `|2 - 6| = 4`, which is greater than `d = 3`.
- 4 is not far, because `|4 - 6| = 2` is at most `d = 3`.
- 3 is not far, because `|3 - 6| = 3` is at most `d = 3`.
- Two elements are far, so the distance value is 2.

### Example 3

```
Input: arr1 = [2,1,100,3], arr2 = [-5,-2,10,-3,7], d = 6
Output: 1
```

**Explanation:**

- 100 is far. Its nearest value in `arr2` is 10, and `|100 - 10| = 90`, which is greater than `d = 6`.
- 2 is not far, because `|2 - (-2)| = 4` is at most `d = 6`.
- 1 is not far, because `|1 - (-2)| = 3` is at most `d = 6`.
- 3 is not far, because `|3 - 7| = 4` is at most `d = 6`.
- One element is far, so the distance value is 1.

## Constraints

- `1 <= arr1.length, arr2.length <= 500`
- `-1000 <= arr1[i], arr2[j] <= 1000`
- `0 <= d <= 100`
