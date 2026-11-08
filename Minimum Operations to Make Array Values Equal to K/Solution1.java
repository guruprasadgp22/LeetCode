class Solution {
    public int minOperations(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele: nums) {
            if(ele < k) {
                return -1;
            }

            if(ele > k) {
                set.add(ele);
            }
        }

        return set.size();
    }
}
