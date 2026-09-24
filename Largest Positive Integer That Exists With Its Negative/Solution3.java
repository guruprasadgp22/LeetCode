class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> num = new HashSet<>();

        int maxEle = -1;

        for(int ele: nums) {
            if(num.contains(-ele)) {
                maxEle = Math.max(maxEle, Math.max(ele, -ele));
            } else {
                num.add(ele);
            }
        }

        return maxEle;
    }
}
