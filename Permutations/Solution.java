class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int index = 0;

        permutation(nums, index, result);

        return result;
    }

    public void permutation(int[] nums, int index, List<List<Integer>> result) {
        if(index == nums.length) {
            List<Integer> ans = new ArrayList<>();
            for(int ele: nums) {
                ans.add(ele);
            }
            result.add(ans);
            return;
        }

        for(int i=index;i<nums.length;i++) {
            swap(nums, index, i);
            permutation(nums, index+1, result);
            swap(nums, index, i);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
