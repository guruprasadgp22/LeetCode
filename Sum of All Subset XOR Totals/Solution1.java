class Solution {
    List<List<Integer>> allSub;
    public int subsetXORSum(int[] nums) {
        allSub = new ArrayList<>();
        List<Integer> currSub = new ArrayList<>();

        solve(nums, 0, currSub);

        int total = 0;
        for(List<Integer> ls: allSub) {
            int xor = 0;
            for(int n: ls) {
                xor ^= n;
            }

            total += xor;
        }

        return total;
    }

    private void solve(int[] nums, int index, List<Integer> currSub) {
        if(index == nums.length) {
            allSub.add(new ArrayList<>(currSub));
            return;
        }

        currSub.add(nums[index]);
        solve(nums, index+1, currSub);
        currSub.removeLast();
        solve(nums, index+1, currSub);
    }
}
