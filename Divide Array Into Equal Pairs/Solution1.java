class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele: nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        for(int ele: map.values()) {
            if(ele % 2!= 0) {
                return false;
            }
        }

        return true;
    }
}
