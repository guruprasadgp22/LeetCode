class Solution {
    public int minChanges(String s) {
        int currChar = s.charAt(0);
        int count = 0;
        int cost = 0;

        for (char ch : s.toCharArray()) {
            if(currChar == ch) {
                count++;
                continue;
            }
            if(count % 2 == 0) {
                count = 1;
            } else {
                cost++;
                count = 0;
            }

            currChar = ch;
        }

        return cost;
    }
}
