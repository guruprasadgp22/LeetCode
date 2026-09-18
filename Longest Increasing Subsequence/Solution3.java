class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        LinkedList<Integer> list = new LinkedList<>();

        for(int i=0;i<n;i++) {
            int index = binarySearch(list, nums[i]);
            if(index == list.size()) {
                list.add(nums[i]);
            } else {
                list.set(index, nums[i]);
            }
            System.out.println("Output: " + list);
        }

        return list.size();
    }

    private int binarySearch(LinkedList<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        int result = list.size();

        while(left < right) {
            int mid = left + (right - left)/2;

            if(list.get(mid) < target) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid;
            }
        }

        return result;
    }
}
