class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for(int ele: arr1) {
            boolean isValid = true;
            for(int val: arr2) {
                if(Math.abs(ele - val) <= d) {
                    isValid = false;
                    break;
                }
            }

            if(isValid) {
                count++;
            }
        }

        return count;
    }
}
