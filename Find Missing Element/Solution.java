class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length-1];

        int j = 1;
        for(int i=min+1;i<max;i++) {
            if(nums[j] != i) {
                list.add(i);
            } else {
                j++;
            }
        }

        return list;
    }
}
