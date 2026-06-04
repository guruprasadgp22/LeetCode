class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        helper(s, result, current);
        return result;
    }

    public void helper(String s, List<List<String>> result, List<String> current) {
        if(s.length() == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=0;i<s.length();i++) {
            String part = s.substring(0, i+1);

            if(isPalindrome(part)) {
                current.addLast(part);
                helper(s.substring(0,i+1), result, current);
                current.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
