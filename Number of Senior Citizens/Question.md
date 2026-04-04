# Passengers Who Are Over 60

**Difficulty:** Easy

## Problem Statement

You are given a 0-indexed array of strings `details`. Each element of `details` provides information about a given passenger compressed into a string of length `15`. The system is such that:

- The first **10** characters consist of the phone number of the passenger.
- The **11th** character denotes the gender of the person.
- The **12th and 13th** characters indicate the age of the person.
- The **last two** characters determine the seat allotted to that person.

Return the number of passengers who are strictly more than 60 years old.

## Examples

**Example 1**
```
Input:  details = ["7868190130M7522","5303914400F9211","9273338290F4010"]
Output: 2
Explanation: The passengers at indices 0, 1, and 2 have ages 75, 92, and 40.
             There are 2 passengers who are over 60 years old.
```

**Example 2**
```
Input:  details = ["1313579440F2036","2921522980M5644"]
Output: 0
Explanation: None of the passengers are older than 60.
```

## Constraints

- `1 <= details.length <= 100`
- `details[i].length == 15`
- `details[i]` consists of digits from `'0'` to `'9'`.
- `details[i][10]` is either `'M'`, `'F'`, or `'O'`.
- The phone numbers and seat numbers of the passengers are distinct.
