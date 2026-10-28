class Solution {
    public String clearDigits(String s) {
        StringBuilder curr = new StringBuilder(s);
        int i = 0;

        while(i < curr.length()) {
            if(Character.isDigit(curr.charAt(i))) {
                curr.deleteCharAt(i);
                if(i-1 >= 0) {
                    curr.deleteCharAt(i-1);
                    i--;
                }
            } else {
                i++;
            }
        }

        return curr.toString();
    }
}
