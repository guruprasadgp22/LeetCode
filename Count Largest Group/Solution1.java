class Solution {
    public int countLargestGroup(int n) {
        int[] freq = new int[37];
        for(int i=1;i<=n;i++) {
            String num = String.valueOf(i);
            int sum = 0;
            for(int j=0;j<num.length();j++) {
                sum += num.charAt(j) - '0';
            }
            freq[sum]++;
        }

        Arrays.sort(freq);
        int high = freq[36];
        int max = 1;
        for(int i=35;i>=0;i--) {
            if(freq[i] == high) {
                max++;
            } else {
                break;
            }
        }
        return max;
    }
}
