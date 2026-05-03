class Solution {
    public int minOperations(String s) {
        int misMatch = 0;

        for(int i=0;i<s.length();i++) {
            char excepted = (i % 2 == 0) ? '0': '1';

            if(s.charAt(i) != excepted) {
                misMatch++;
            }
        }

        int misMatch1 = s.length() - misMatch;

        return Math.min(misMatch1, misMatch);
    }
}
