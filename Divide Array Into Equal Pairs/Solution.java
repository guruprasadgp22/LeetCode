class Solution {
    public boolean divideArray(int[] nums) {
        if(nums.length % 2 != 0) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int ele: nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}
