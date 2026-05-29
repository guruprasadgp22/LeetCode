class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele: nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        int operation = 0;

        for(int freq: map.values()) {
            if(freq == 1) {
                return -1;
            }

            operation += (freq + 2)/3;
        }

        return operation;
    }
}
