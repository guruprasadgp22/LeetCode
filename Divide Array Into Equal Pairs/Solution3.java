class Solution {
    public boolean divideArray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele: nums) {
            if(set.contains(ele)) {
                set.remove(ele);
            } else {
                set.add(ele);
            }
        }

        return set.size() == 0;
    }
}
