class Solution {
    public boolean checkString(String s) {
        boolean a = true;
        boolean b = false;

        for(char ch: s.toCharArray()) {
            if(ch == 'b') {
                b = true;
            } else if(ch == 'a') {
                if(b) {
                    return false;
                }
            }
        }

        return true;
    }
}
