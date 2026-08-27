class Solution {
    public int maxProduct(int[] nums) {
        int first = 0;
        int second = -1;

        for(int ele: nums) {
            if(ele > first) {
                second = first;
                first = ele;
            } else if(ele > second) {
                second = ele;
            }
        }

        return (second - 1) * (first - 1);
    }
}
