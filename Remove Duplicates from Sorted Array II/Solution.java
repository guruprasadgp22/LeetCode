class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 2;
        int fast = 2;

        while(fast < nums.length) {
            if(nums[fast] != nums[slow-2]) {
                nums[slow++] = nums[fast++];
            } else {
                fast++;
            }
        }

        return slow;
    }
}
