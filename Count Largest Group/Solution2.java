class Solution {
    public int countLargestGroup(int n) {
        int max = 0;
        int count = 0;
        int[] freq = new int[37];
        for(int i=1;i<=n;i++) {
            int sum = find(i);
            freq[sum]++;
            if(freq[sum] > max) {
                max = freq[sum];
                count = 1;
            } else if(freq[sum] == max) {
                count++;
            }
        }

        return count;
    }

    private int find(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
