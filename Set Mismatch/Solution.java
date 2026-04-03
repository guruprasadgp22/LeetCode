class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        int n = nums.length;
        int fre[] = new int[n+1];

        for(int ele: nums) {
            fre[ele]++;
        }

        for(int i=1;i<=n;i++) {
            if(fre[i] == 2) {
                ans[0] = i;
            }
            if(fre[i]==0){
                ans[1] = i ;
            }
        }

        return ans;
    }
}
