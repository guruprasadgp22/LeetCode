class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            int index = find(nums[i]);
            if(i == index) {
                return i;
            }
        }
        return -1;
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
