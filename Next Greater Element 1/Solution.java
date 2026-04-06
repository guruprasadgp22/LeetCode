class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] ans = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--) {
            while(st.size() > 0 && st.peek() <= nums2[i]) {
                st.pop();
            }

            if(st.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], st.peek());
            }

            st.add(nums2[i]);
        }

        for(int i=0;i<nums1.length;i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}
