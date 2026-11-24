class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(nums[i] == key) {
                int start = Math.max(i-k, Math.max(0, res.isEmpty()? 0: res.getLast()+1));
                int end = Math.min(i+k,n-1);
                for(int j=start;j<=end;j++) {
                    res.add(j);
                }
            }
        }

        return res;
    }
}
