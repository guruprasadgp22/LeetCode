class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int ele : freq) {
            if (ele == 0) {
                continue;
            }

            if (ele % 2 == 0) {
                min = Math.min(min, ele);
            } else {
                max = Math.max(ele, max);
            }
        }

        return max - min;
    }
}
