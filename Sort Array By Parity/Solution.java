class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while(left < right) {
            while(left < right && nums[left] % 2 == 0) {
                left++;
            }

            while(left < right && nums[right] % 2 != 0) {
                right--;
            }

            swap(left, right, nums);

            left++;
            right--;
        }

        return nums;
    }

    private void swap(int i, int j, int[] arr) {
        int temp =  arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
