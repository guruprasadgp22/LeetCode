class Solution {
    public String largestGoodInteger(String num) {
        char[] arr = num.toCharArray();
        String ans = "";
        int max = 0;
        String test = String.valueOf(arr[0]);
        for(int i=1;i<arr.length;i++) {
            if(arr[i-1] == arr[i]) {
                test += String.valueOf(arr[i]);
            } else {
                test = String.valueOf(arr[i]);
            }

            if(test.length() == 3) {
                max = Math.max(max, Integer.parseInt(test));
                ans = String.valueOf(max);
            }
        }

        return (ans.equals("0"))? "000" : ans;
    }
}
