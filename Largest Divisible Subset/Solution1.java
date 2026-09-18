class Solution {
    HashMap<String, List<Integer>> dp;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int prevI = -1;

        dp = new HashMap<>();

        return solve(i, prevI, nums);
    }

    private List<Integer> solve(int i, int prevI, int[] nums) {
        if(i >= nums.length) {
            return new ArrayList<>();
        }

        String s = i + "_" + prevI;
        if(dp.containsKey(s)) {
            return new ArrayList<>(dp.get(s));
        }

        List<Integer> skip = solve(i+1, prevI, nums);

        List<Integer> take = new ArrayList<>();

        if(prevI == -1 || nums[i] % nums[prevI] == 0) {
            take.add(nums[i]);
            List<Integer> temp = solve(i+1, i, nums);
            take.addAll(temp);
        }

        List<Integer> result = skip.size() < take.size() ? take: skip;
        dp.put(s, result);
        return result;
    }
}
