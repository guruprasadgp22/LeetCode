class Solution {
    public long maxBalancedSubsequenceSum(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = nums[i] - i;
        }

        TreeMap<Integer, Long> map = new TreeMap<>();
        long result = Long.MIN_VALUE;
        for(int i=0;i<n;i++) {
            if(nums[i] <= 0) {
                result = Math.max(result, nums[i]);
            } else {
                long temp = nums[i];
                if(map.floorKey(arr[i]) != null) {
                    temp += map.get(map.floorKey(arr[i]));
                }

                while(map.ceilingKey(arr[i]) != null && map.get(map.ceilingKey(arr[i])) < temp) {
                    map.remove(map.ceilingKey(arr[i]));
                }

                if(map.floorKey(arr[i]) == null || map.get(map.floorKey(arr[i])) < temp) {
                    map.put(arr[i], temp);
                }

                result = Math.max(result, temp);
            }
        }

        return result;
    }
}
