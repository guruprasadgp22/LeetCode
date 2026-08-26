class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
        int count = 0;
        String result = "";
        int n = s.length();

        for(int right = 0; right < n; right++) {
            if(s.charAt(right) == '1') {
                count++;
            }

            if(count == k) {
                int len = right - left + 1;
                String temp = s.substring(left, right+1);

                if(result.isEmpty() || result.length() > len || (temp.length() == result.length() && temp.compareTo(result) < 0)) {
                    result = temp;
                }
            }

            while(count >= k || (left < n && s.charAt(left) == '0' )) {
                if(s.charAt(left) == '1') {
                    count--;
                }

                left++;
            }
        }

        return result;
    }
}
