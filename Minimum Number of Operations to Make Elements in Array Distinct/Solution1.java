class Solution {
    public int minimumOperations(int[] nums) {
        int op = 0;
        for(int i=0;i<nums.length;i+=3) {
            if(check(i, nums)) {
                return op;
            }
            op++;
        }
        return op;
    }

    private boolean check(int i, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(;i<nums.length;i++) {
            if(set.contains(nums[i])) {
                return false;
            }

            set.add(nums[i]);
        }

        return true;
    }
}
