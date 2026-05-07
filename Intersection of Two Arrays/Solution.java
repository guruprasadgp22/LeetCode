class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> result = new TreeSet<>();
        HashSet<Integer> set = new HashSet<>();

        for(int ele: nums1) {
            set.add(ele);
        }

        for(int ele: nums2) {
            if(set.contains(ele)) {
                result.add(ele);
            }
        }

        int i = 0;
        int[] ans = new int[result.size()];
        for(int ele: result) {
            ans[i++] = ele;
        }

        return ans;
    }
}
