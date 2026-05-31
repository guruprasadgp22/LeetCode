class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> curr = new LinkedList<>();
        int i = 0;

        subset(nums, i, res, curr);

        return res;
    }

    public void subset(int[] nums, int i, List<List<Integer>> res, List<Integer> curr) {
        if(i == nums.length) {
            res.add(new LinkedList<>(curr));
            return;
        }

        curr.addLast(nums[i]);
        subset(nums, i+1, res, curr);

        curr.removeLast();

        int index = i + 1;
        while(index < nums.length && nums[index] == nums[index-1]) {
            index++;
        }

        subset(nums, index, res, curr);
    }
}
