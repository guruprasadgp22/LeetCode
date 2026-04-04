class Solution {
    public int missingMultiple(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int ele: nums) {
            list.add(ele);
        }
        int i = 1;
        while(true) {
            int temp = k * i;
            if(!list.contains(temp)){
                return temp;
            }
            i++;
        }
    }
}
