class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String str: details) {
            char ch1 = str.charAt(11);
            char ch2 = str.charAt(12);
            int num = (ch1 - '0') * 10 + (ch2 - '0');
            if(num > 60) {
                count++;
            }
        }

        return count;
    }
}
