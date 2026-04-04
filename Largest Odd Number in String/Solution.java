class Solution {
    public String largestOddNumber(String num) {
        String ans = "";
        int max = Integer.MIN_VALUE;
        int n = Integer.parseInt(String.valueOf(num.charAt(num.length()-1)));
        if(n % 2 != 0) {
            ans = String.valueOf(num);
            return ans;
        }
        for(int i=num.length()-2;i>=0;i--) {
            int number = Integer.parseInt(String.valueOf(num.charAt(i)));
            if(number % 2 != 0) {
                ans = num.substring(0, i+1);
                break;
            }
        }

        return ans;
    }
}
