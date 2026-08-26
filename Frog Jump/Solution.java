class Solution {
    HashMap<Integer, Integer> map;
    int dp[][];
    public boolean canCross(int[] stones) {
        int n = stones.length;
        map = new HashMap<>();
        for(int i=0;i<n;i++) {
            map.put(stones[i], i);
        }

        dp = new int[2001][2001];
        for(int i=0;i<2001;i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(stones, 0, 0);
    }

    private boolean solve(int[] stones, int curr_stone_idx, int prevJump) {
        if(curr_stone_idx == stones.length-1) {
            return true;
        }
        if(dp[curr_stone_idx][prevJump] != -1) {
            return dp[curr_stone_idx][prevJump] == 1;
        }

        boolean result = false;
        for(int nextJump = prevJump-1; nextJump <= prevJump+1; nextJump++) {
            if(nextJump > 0) {
                int nextStone = stones[curr_stone_idx] + nextJump;

                if(map.containsKey(nextStone)) {
                    result = result || solve(stones, map.get(nextStone), nextJump);
                }
            }
        }

        dp[curr_stone_idx][prevJump] = result? 1: 0;
        return result;
    }
}
