class Solution {
    public int findLucky(int[] arr) {
        int n = arr.length;

        for(int i=0;i<n;i++) {
            int val = arr[i] & 65535;
            if(val <= n) {
                arr[val-1] += (1 <<16);
            }
        }

        for(int i=n;i>=1;i--) {
            if((arr[i-1] >> 16) == i){
                return i;
            }
        }

        return -1;
    }
}
