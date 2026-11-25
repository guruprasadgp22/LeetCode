class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1; 
        for(int i=n-1;i>0;i--) {
            if(nums[i-1] < nums[i]) {
                index = i-1;
                break;
            }
        }

        if(index == -1) {
            reverse(nums, 0, n-1);
        } else {
            for(int i=n-1;i>=index+1;i--) {
                if(nums[index] < nums[i]) {
                    int temp = nums[index];
                    nums[index] = nums[i];
                    nums[i] = temp;
                    reverse(nums, index+1, n-1);
                    break;
                }
            }
        }
    }

    private void reverse(int[] arr, int left, int right) {
        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
