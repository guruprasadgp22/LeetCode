class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }

    public int binarySearch(int[] arr, int start, int end, int k) {
        if(start > end) {
            return -1;
        }

        int mid = start + (end - start)/2;

        if(arr[mid] == k) {
            return mid;
        } else if(arr[mid] > k) {
            return binarySearch(arr, start, mid - 1, k);
        } else {
            return binarySearch(arr, mid + 1, end, k);
        }
    } 
}
