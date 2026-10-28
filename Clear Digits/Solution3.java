class Solution {
    public String clearDigits(String s) {
        StringBuilder curr = new StringBuilder();
        for(char ch: s.toCharArray()) {
            if(Character.isDigit(ch)) {
                if(!curr.isEmpty()) {
                    curr.deleteCharAt(curr.length()-1);
                }
            } else {
                curr.append(ch);
            }
        }

        return curr.toString();
    }
}
