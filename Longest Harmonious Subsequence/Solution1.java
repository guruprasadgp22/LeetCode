class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int maxLen = 0;
        int i = 0;
        int j = 1;
// -3,-3,-2,-1,-1,-1
        while(j < nums.length) {
            while(i < j && nums[j] - nums[i] > 1){
                i++;
            }
            if(nums[j] - nums[i] == 1) {
                maxLen = Math.max(maxLen, j - i +1);
            }
            j++;
        }
        return maxLen;
    }
}
