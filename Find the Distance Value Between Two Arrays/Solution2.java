class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        int n = arr2.length;
        Arrays.sort(arr2);
        for(int ele: arr1) {
            int idx = binarySearch(arr2, ele);
            if(idx == 0) {
                count += (Math.abs(ele - arr2[idx]) > d)? 1: 0;
            } else if(idx >= n) {
                count += (Math.abs(ele - arr2[n-1]) > d)? 1: 0;
            } else {
                count += (Math.abs(ele - arr2[idx]) > d && Math.abs(ele - arr2[idx - 1]) > d)? 1 : 0;
            }
        }

        return count;
    }

    private int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length-1;
        while(low < high) {
            int mid = low + (high - low)/2;
            if(arr[mid] >= key) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
