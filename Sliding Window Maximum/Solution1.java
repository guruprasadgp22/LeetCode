class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int idx = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<nums.length;i++) {
            while(!dq.isEmpty() && dq.getFirst() <= i - k) {
                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[i] > nums[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
            if(i >= k-1) {
                res[idx++] = nums[dq.getFirst()];
            }
        }
        return res;
    }
}
