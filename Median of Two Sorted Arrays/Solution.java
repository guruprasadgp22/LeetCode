class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int i = 0;
        int j = 0;
        int k = 0;
        int m = nums1.length;
        int n = nums2.length;
        int[] arr = new int[m+n];

        while(i < m && j < n) {
            if(nums1[i] < nums2[j]) {
                arr[k] = nums1[i];
                i++;
                k++;
            } else {
                arr[k] = nums2[j];
                j++;
                k++;
            }
        }

        while(i < m) {
            arr[k] = nums1[i];
            i++;
            k++;
        }

        while(j < n) {
            arr[k] = nums2[j];
            j++;
            k++;
        }
        double ans = 0.0;
        if(arr.length % 2 == 0) {
            int p = arr.length / 2;
            ans = (double)(arr[p] + arr[p-1])/2;
        } else {
            ans = arr[arr.length/2];
        }

        return ans;
    }
}
