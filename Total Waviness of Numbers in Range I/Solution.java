class Solution {
    public int totalWaviness(int num1, int num2) {
        int result = 0;

        for(int i=num1;i<=num2;i++) {
            String num = String.valueOf(i);
            int count = 0;

            for(int j=1;j<num.length()-1;j++) {
                int n1 = num.charAt(j-1)-'0';
                int n2 = num.charAt(j) - '0';
                int n3 = num.charAt(j+1) - '0';

                if((n2 > n1 && n2 > n3) || (n2 < n1 && n2 < n3)) {
                    count++;
                }
            }

            result += count;
        }

        return result;
    }
}
