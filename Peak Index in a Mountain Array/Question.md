# 852. Peak Index in a Mountain Array

## 📋 Problem Description

You are given an integer mountain array `arr` of length `n` where the values increase to a peak element and then decrease.

Return the index of the peak element.

> **Requirement:** You must solve it in $O(\log n)$ time complexity.

---

## 🔍 Examples

### Example 1
* **Input:** `arr = [0, 1, 0]`
* **Output:** `1`
* **Explanation:** The peak element is `1` at index `1`.

### Example 2
* **Input:** `arr = [0, 2, 1, 0]`
* **Output:** `1`
* **Explanation:** The peak element is `2` at index `1`.

### Example 3
* **Input:** `arr = [0, 10, 5, 2]`
* **Output:** `1`
* **Explanation:** The peak element is `10` at index `1`.

---

## 💡 Explanation

Since the array is guaranteed to be a mountain (strictly increasing up to the peak, then strictly decreasing), we can use **Binary Search** to find the peak in $O(\log n)$ time:

1. Set `left = 0` and `right = arr.length - 1`.
2. Find the midpoint `mid`.
3. Compare `arr[mid]` with its right neighbor `arr[mid + 1]`:
   * If `arr[mid] < arr[mid + 1]`, we are on the ascending slope; the peak is to the right (`left = mid + 1`).
   * If `arr[mid] > arr[mid + 1]`, we are on the descending slope; the peak is at `mid` or to the left (`right = mid`).
4. When `left == right`, we have found the peak index.
