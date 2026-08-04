class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int start = nums[0];
        int end = nums[n-1];

        HashSet<Integer> set = new HashSet<>();
        for(int ele: nums) {
            set.add(ele);
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=start;i<=end;i++) {
            if(set.contains(i)) {
                continue;
            }

            ans.add(i);
        }

        return ans;
    }
}
