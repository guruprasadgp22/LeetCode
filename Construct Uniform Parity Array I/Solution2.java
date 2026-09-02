class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int oddCount = 0;
        int evenCount = 0;

        for(int ele: nums1) {
            if(ele % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        if(oddCount == n || evenCount == n) {
            return true;
        }

        int[] result = new int[n];
        for(int i=0;i<n;i++) {
            if(nums1[i] % 2 == 1) {
                result[i] = nums1[i];
            } else {
                for(int j=0;j<n-1;j++) {
                    System.out.println(nums1[j] + " " + nums1[j+1]);
                    if(Math.abs(nums1[j] - nums1[j+1]) % 2 == 1) {
                                            System.out.println(nums1[j] + " " + nums1[j+1]);
                        result[i] = Math.abs(nums1[j] - nums1[j+1]);
                        System.out.println(result[i]);
                        break;
                    }
                }
            }
        }

        for(int ele: result) {
            if(ele % 2 != 1) {
                return false;
            }
        }

        return true;
    }
}
