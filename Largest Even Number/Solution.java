class Solution {
    public String largestEven(String s) {
        String ans = "";

        for(int i=s.length()-1;i>=0;i--) {
            if(Integer.parseInt(String.valueOf(s.charAt(i))) % 2 == 0) {
                ans += s.substring(0,i+1);
                break;
            }
        }

        return ans;
    }
}
