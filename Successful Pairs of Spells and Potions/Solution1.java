class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int m = spells.length;
        int n = potions.length;
        int[] res = new int[m];
        Arrays.sort(potions);

        for(int i=0;i<m;i++) {
            int ans = binarySearch(potions, spells[i], success);

            res[i] = n - ans;
        }

        return res;
    }

    private int binarySearch(int[] arr, int key, long success) {
        int res = arr.length;
        int left = 0;
        int right = arr.length-1;

        while(left <= right) {
            int mid = left + (right - left)/2;

            long ans = (long)key * arr[mid];
            if(ans >= success) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }
}
