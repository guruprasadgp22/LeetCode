class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i=0;i<n;i++) {
            sum += nums[i];
            map.put(sum, i);
        }

        int targetSum = sum - x;
        sum = 0;
        int longestSubArr = -1;
        for(int i=0;i<n;i++) {
            sum += nums[i];
            int findSum = sum - targetSum;
            if(map.containsKey(findSum)) {
                int index = map.get(findSum);
                longestSubArr = Math.max(longestSubArr, i - index);
            }
        }

        return longestSubArr == -1? longestSubArr: n - longestSubArr;
    }
}
