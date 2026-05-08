# Average Waiting Time

**Difficulty:** Medium

## Problem Statement

There is a restaurant with a single chef. You are given an array `customers`, where `customers[i] = [arrivali, timei]`:

- `arrivali` is the arrival time of the `ith` customer. Arrival times are sorted in non-decreasing order.
- `timei` is the time needed to prepare the order of the `ith` customer.

When a customer arrives, the chef starts preparing their order once idle. The chef prepares food for customers in the order they were given.

Return the average waiting time of all customers. Solutions within `10^-5` from the actual answer are accepted.

## Examples

**Example 1**
```
Input:  customers = [[1,2],[2,5],[4,3]]
Output: 5.00000
Explanation:
  Customer 1: arrives at 1, done at 3, wait = 3 - 1 = 2
  Customer 2: arrives at 2, done at 8, wait = 8 - 2 = 6
  Customer 3: arrives at 4, done at 11, wait = 11 - 4 = 7
  Average = (2 + 6 + 7) / 3 = 5.0
```

**Example 2**
```
Input:  customers = [[5,2],[5,4],[10,3],[20,1]]
Output: 3.25000
Explanation:
  Customer 1: arrives at 5, done at 7,  wait = 2
  Customer 2: arrives at 5, done at 11, wait = 6
  Customer 3: arrives at 10, done at 14, wait = 4
  Customer 4: arrives at 20, done at 21, wait = 1
  Average = (2 + 6 + 4 + 1) / 4 = 3.25
```

## Constraints

- `1 <= customers.length <= 10^5`
- `1 <= arrivali, timei <= 10^4`
- `arrivali <= arrivali+1`
