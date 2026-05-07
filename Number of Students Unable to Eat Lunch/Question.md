# Number of Students Unable to Eat Lunch

**Difficulty:** Easy

## Problem Statement

The school cafeteria offers circular (`0`) and square (`1`) sandwiches. All students stand in a queue, each preferring one type.

At each step:
- If the student at the front of the queue prefers the sandwich on top of the stack, they take it and leave the queue.
- Otherwise, they go to the end of the queue.

This continues until none of the remaining students want the top sandwich.

Given two integer arrays `students` and `sandwiches`, return the number of students that are unable to eat.

## Examples

**Example 1**
```
Input:  students = [1,1,0,0], sandwiches = [0,1,0,1]
Output: 0
Explanation: All students are eventually able to eat their preferred sandwich.
```

**Example 2**
```
Input:  students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
Output: 3
```

## Constraints

- `1 <= students.length, sandwiches.length <= 100`
- `students.length == sandwiches.length`
- `sandwiches[i]` is `0` or `1`.
- `students[i]` is `0` or `1`.
