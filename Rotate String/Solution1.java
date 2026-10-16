class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        String doubled = s + s;
        for(int i=0;i<n;i++) {
            String sub = doubled.substring(i, i+n);
            if(goal.equals(sub)) {
                return true;
            }
        }

        return false;
    }
}
