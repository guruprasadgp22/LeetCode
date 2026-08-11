# 🧩 LeetCode Daily Grind

> Solving one (or more) LeetCode problems every day — tracking progress, patterns, and growth.

<p align="center">
  <img src="https://img.shields.io/badge/Problems%20Solved-0-brightgreen" alt="Problems Solved"/>
  <img src="https://img.shields.io/badge/Current%20Streak-0%20days-orange" alt="Streak"/>
  <img src="https://img.shields.io/badge/Languages-Python%20%7C%20Java%20%7C%20C%2B%2B-blue" alt="Languages"/>
  <img src="https://img.shields.io/github/last-commit/USERNAME/REPO_NAME" alt="Last Commit"/>
</p>

---

## 📌 About

This repository is my personal log of daily [LeetCode](https://leetcode.com/) practice. Each solution includes the problem statement summary, my approach, time & space complexity, and clean, commented code.

The goal: build consistency, sharpen problem-solving skills, and create a searchable archive of patterns for interview prep.

---

## 📊 Progress

| Metric              | Count |
|---------------------|-------|
| Total Solved         | 0     |
| Easy                 | 0     |
| Medium                | 0     |
| Hard                  | 0     |
| Current Streak        | 0 days |
| Longest Streak         | 0 days |

> Update this table manually or automate it with a script (see [Automation](#-automation) below).

---

## 📁 Repository Structure

```
leetcode-daily/
├── README.md
├── 0001-two-sum/
│   ├── solution.py
│   ├── README.md
│   └── notes.md
├── 0020-valid-parentheses/
│   ├── solution.py
│   └── README.md
├── 0206-reverse-linked-list/
│   └── solution.py
├── scripts/
│   └── update_readme.py
└── templates/
    └── problem_template.md
```

Each problem folder is named `NNNN-problem-slug` (zero-padded LeetCode problem number + kebab-case title), containing:
- **`solution.py`** (or `.java`, `.cpp`, etc.) — the working solution
- **`README.md`** — problem summary, approach, and complexity analysis
- **`notes.md`** *(optional)* — edge cases, mistakes made, alternative approaches

---

## 🗂️ Solutions Log

| # | Date | Problem | Difficulty | Topic | Language | Solution |
|---|------|---------|------------|-------|----------|----------|
| 1 | 2026-08-01 | [Two Sum](https://leetcode.com/problems/two-sum/) | Easy | Array, Hash Map | Python | [Link](./0001-two-sum/) |
| 2 | 2026-08-02 | [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/) | Easy | Stack | Python | [Link](./0020-valid-parentheses/) |
| 3 | 2026-08-03 | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) | Easy | Linked List | Python | [Link](./0206-reverse-linked-list/) |

> Add a new row every day you solve a problem. Newest entries at the bottom (or top — pick a convention and stick with it).

---

## 🏷️ Topics Covered

<p>
  <img src="https://img.shields.io/badge/Array-12-lightgrey"/>
  <img src="https://img.shields.io/badge/String-8-lightgrey"/>
  <img src="https://img.shields.io/badge/Hash%20Map-6-lightgrey"/>
  <img src="https://img.shields.io/badge/Dynamic%20Programming-5-lightgrey"/>
  <img src="https://img.shields.io/badge/Tree-4-lightgrey"/>
  <img src="https://img.shields.io/badge/Graph-3-lightgrey"/>
  <img src="https://img.shields.io/badge/Two%20Pointers-3-lightgrey"/>
  <img src="https://img.shields.io/badge/Sliding%20Window-2-lightgrey"/>
</p>

---

## 🧠 Solution Template

Every problem folder's `README.md` follows this format:

````markdown
# [Problem Number]. Problem Title

**Difficulty:** Easy / Medium / Hard
**Topics:** Array, Hash Map
**Link:** https://leetcode.com/problems/problem-slug/

## Problem
Brief restatement of the problem.

## Approach
Explanation of the strategy used to solve it.

## Complexity
- Time: O(n)
- Space: O(1)

## Code
See `solution.py`
````

---

## ⚙️ Automation

Optionally automate tracking with a script that scans folders and regenerates the log table + progress stats:

```bash
python scripts/update_readme.py
```

You can also wire this into a GitHub Action to run on every push, so the table and badges stay in sync automatically.

---

## 🛠️ Tech Stack

- **Languages:** Python, Java, C++ (pick what you use)
- **Testing:** Local test cases per problem, or `pytest` for Python solutions
- **CI (optional):** GitHub Actions to run tests on push

---

## 🚀 How to Run a Solution

```bash
# Clone the repo
git clone https://github.com/USERNAME/REPO_NAME.git
cd REPO_NAME

# Navigate to a problem
cd 0001-two-sum

# Run the solution
python solution.py
```

---

## 📈 Goals

- [ ] Solve at least 1 problem every day
- [ ] Cover all major topics (Arrays, DP, Graphs, Trees, Backtracking, etc.)
- [ ] Reach 100 problems solved
- [ ] Reach 300 problems solved
- [ ] Revisit and optimize old solutions

---

## 🤝 Contributing

This is a personal learning repo, but suggestions, alternative approaches, or bug fixes are welcome via issues or pull requests.

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).

---

<p align="center">Made with consistency, coffee, and a lot of debugging. ☕</p>
