class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int total = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<nums.length;i++) {
            while(!dq.isEmpty() && dq.peekFirst() < i- k) {
                dq.removeFirst();
            }

            int best = dq.isEmpty()? 0: Math.max(0, dp[dq.peekFirst()]);
            dp[i] = nums[i] + best;
            total = Math.max(total, dp[i]);
            while(!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]) {
                dq.removeLast();
            }

            dq.addLast(i);
        }

        return total;
    }
}
