class Solution {
    public int firstMissingPositive(int[] nums) {
       HashSet<Integer> set = new HashSet<>();

       for(int ele: nums) {
            if(ele > 0) {
                set.add(ele);
            }
       }
        int n = set.size();
        for(int i=1;i<=n;i++) {
            if(set.contains(i)) {
                continue;
            }

            return i;
        } 

        return n+1;
    }
}
