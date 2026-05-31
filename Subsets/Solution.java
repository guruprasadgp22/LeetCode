class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<Integer> curr = new LinkedList<>();
        int i = 0;

        subset(nums, i, ans, curr);
        return ans;
    }

    public void subset(int[] nums, int i, List<List<Integer>> ans, LinkedList<Integer> curr) {
        if(i == nums.length) {
            ans.add(new LinkedList<>(curr));
            return;
        }

        curr.addLast(nums[i]);
        subset(nums,i+1, ans, curr);

        curr.removeLast();
        subset(nums, i+1, ans, curr);
    }
}
