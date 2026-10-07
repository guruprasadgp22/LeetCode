class Solution {
    char[][] arr = {{'a', 'b', 'c'},
                    {'d', 'e', 'f'},
                    {'g', 'h', 'i'},
                    {'j', 'k', 'l'},
                    {'m', 'n', 'o'},
                    {'p', 'q', 'r', 's'},
                    {'t', 'u', 'v'},
                    {'w', 'x', 'y', 'z'}
    };

    List<String> result;
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        curr.add("");
        solve(0, digits, curr);
        return result;
    }

    private void solve(int i, String digits, List<String> curr) {
        if(i == digits.length()) {
            result = curr;
            return;
        }

        List<String> ans = new ArrayList<>();
        for(String s: curr) {
            for(char ch: arr[digits.charAt(i) - '2']) {
                ans.add(s + String.valueOf(ch));
            }
        }

        solve(i+1, digits, ans);
    }
}
