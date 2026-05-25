class Solution {
    public int minimumSwaps(int[] nums) {
        int n = nums.length;
        int left = 0;
        int count = 0;
        int right = n-1;

        while(left < right) {
            while(left < n && nums[left] != 0) {
                left++;
            }

            while(right >= 0 && nums[right] == 0) {
                right--;
            }
            
            System.out.println(left + " - " + right);
            
            if(left > right) {
                break;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            count++;
            left++;
            right--;
        }

        return count;
    }
}
