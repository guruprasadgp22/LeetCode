import os, requests, re, sys
from pathlib import Path

SESSION = os.environ.get("LEETCODE_SESSION", "")
CSRF    = os.environ.get("LEETCODE_CSRF_TOKEN", "")
FOLDER  = "LeetCode"
USERNAME = "guruprasadgp22"

HEADERS = {
    "Content-Type": "application/json",
    "Cookie": f"csrftoken={CSRF}; LEETCODE_SESSION={SESSION}",
    "x-csrftoken": CSRF,
    "Referer": "https://leetcode.com",
    "User-Agent": "Mozilla/5.0",
}

EXT = {
    "cpp": "cpp", "java": "java", "python": "py", "python3": "py",
    "c": "c", "csharp": "cs", "javascript": "js", "typescript": "ts",
    "ruby": "rb", "swift": "swift", "golang": "go", "scala": "scala",
    "kotlin": "kt", "rust": "rs", "php": "php",
}

def get_submissions():
    query = """
    query ($username: String!) {
      recentAcSubmissionList(username: $username, limit: 1000) {
        id title titleSlug lang
      }
    }
    """
    r = requests.post(
        "https://leetcode.com/graphql",
        headers=HEADERS,
        json={"query": query, "variables": {"username": USERNAME}},
        timeout=30,
    )
    return r.json()["data"]["recentAcSubmissionList"]

def get_code(submission_id):
    query = """
    query ($submissionId: Int!) {
      submissionDetails(submissionId: $submissionId) {
        code
      }
    }
    """
    r = requests.post(
        "https://leetcode.com/graphql",
        headers=HEADERS,
        json={"query": query, "variables": {"submissionId": int(submission_id)}},
        timeout=30,
    )
    data = r.json()
    details = data.get("data", {}).get("submissionDetails")
    if not details:
        print(f"  WARNING: Could not fetch code — cookies may be expired or empty.")
        return None
    return details["code"]

def slugify(title):
    return re.sub(r"[^a-z0-9]+", "_", title.lower()).strip("_")

if not SESSION or not CSRF:
    print("ERROR: LEETCODE_SESSION or LEETCODE_CSRF_TOKEN is empty!")
    print("Go to repo Settings → Secrets and add them.")
    sys.exit(1)

Path(FOLDER).mkdir(exist_ok=True)
submissions = get_submissions()
print(f"Found {len(submissions)} accepted submissions.")
total, failed = 0, 0

for s in submissions:
    ext  = EXT.get(s["lang"], "txt")
    name = f"{slugify(s['title'])}.{ext}"
    path = Path(FOLDER) / name
    if not path.exists():
        code = get_code(s["id"])
        if code:
            path.write_text(code, encoding="utf-8")
            print(f"Saved: {name}")
            total += 1
        else:
            failed += 1

print(f"Done. {total} saved, {failed} failed (fix cookies if failed > 0).")
