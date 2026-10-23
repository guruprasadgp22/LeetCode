class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        map.put(0, 1);
        for(int ele: nums) {
            currSum += ele;

            if(map.containsKey(currSum - goal)) {
                count += map.get(currSum - goal);
            }
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
}
