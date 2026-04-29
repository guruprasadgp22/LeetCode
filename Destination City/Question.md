# Destination City

**Difficulty:** Easy

## Problem Statement

You are given the array `paths`, where `paths[i] = [cityAi, cityBi]` means there exists a direct path going from `cityAi` to `cityBi`. Return the destination city, that is, the city without any path outgoing to another city.

It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.

## Examples

**Example 1**
```
Input:  paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
Output: "Sao Paulo"
Explanation: "London" → "New York" → "Lima" → "Sao Paulo"
```

**Example 2**
```
Input:  paths = [["B","C"],["D","B"],["C","A"]]
Output: "A"
Explanation: All paths eventually lead to "A", which has no outgoing path.
```

**Example 3**
```
Input:  paths = [["A","Z"]]
Output: "Z"
```

## Constraints

- `1 <= paths.length <= 100`
- `paths[i].length == 2`
- `1 <= cityAi.length, cityBi.length <= 10`
- `cityAi != cityBi`
- All strings consist of lowercase and uppercase English letters and the space character.
