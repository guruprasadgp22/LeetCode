class Solution {
    public int findMaxLength(int[] nums) {
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int currSum = 0;
        for(int i=0;i<nums.length;i++) {
            currSum += nums[i] == 1? 1: -1;
            if(map.containsKey(currSum)) {
                int len = i - map.get(currSum);
                maxLen = Math.max(maxLen, len);
            } else {
                map.put(currSum, i);
            }
        }

        return maxLen;
    }
}
