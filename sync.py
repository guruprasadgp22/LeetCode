import os, requests, re
from pathlib import Path

SESSION = os.environ["LEETCODE_SESSION"]
CSRF    = os.environ["LEETCODE_CSRF_TOKEN"]
FOLDER  = "LeetCode"
HEADERS = {
    "Content-Type": "application/json",
    "Cookie": f"csrftoken={CSRF}; LEETCODE_SESSION={SESSION}",
    "x-csrftoken": CSRF,
    "Referer": "https://leetcode.com",
}

EXT = {
    "cpp": "cpp", "java": "java", "python": "py", "python3": "py",
    "c": "c", "csharp": "cs", "javascript": "js", "typescript": "ts",
    "ruby": "rb", "swift": "swift", "golang": "go", "scala": "scala",
    "kotlin": "kt", "rust": "rs", "php": "php",
}

QUERY = """
query {
  recentAcSubmissionList(username: "guruprasadgp22", limit: 1000) {
    id title titleSlug lang
  }
}
"""

def get_code(submission_id):
    q = """
    query submissionDetails($submissionId: Int!) {
      submissionDetails(submissionId: $submissionId) {
        code
      }
    }
    """
    r = requests.post(
        "https://leetcode.com/graphql",
        headers=HEADERS,
        json={"query": q, "variables": {"submissionId": int(submission_id)}},
    )
    data = r.json()
    return data["data"]["submissionDetails"]["code"]

def get_submissions():
    r = requests.post(
        "https://leetcode.com/graphql",
        headers=HEADERS,
        json={"query": QUERY},
    )
    return r.json()["data"]["recentAcSubmissionList"]

def slugify(title):
    return re.sub(r"[^a-z0-9]+", "_", title.lower()).strip("_")

Path(FOLDER).mkdir(exist_ok=True)
submissions = get_submissions()
total = 0

for s in submissions:
    ext  = EXT.get(s["lang"], "txt")
    name = f"{slugify(s['title'])}.{ext}"
    path = Path(FOLDER) / name
    if not path.exists():
        code = get_code(s["id"])
        path.write_text(code, encoding="utf-8")
        print(f"Saved: {name}")
        total += 1

print(f"Done. {total} new solutions saved.")
