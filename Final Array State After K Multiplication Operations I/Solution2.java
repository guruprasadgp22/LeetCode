class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> nums[a] != nums[b]? nums[a] - nums[b]: a - b);
        for(int i=0;i<nums.length;i++) {
            queue.add(i);
        }

        while(k > 0) {
            int idx = queue.poll();
            nums[idx] = nums[idx] * multiplier;
            queue.add(idx);
            k--;
        }

        return nums;
    }
}
