class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele: nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        Integer[] arr = new Integer[nums.length];
        for(int i=0;i<nums.length;i++) {
            arr[i] = nums[i];
        }

        Arrays.sort(arr, (a, b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);

            if(freqA != freqB) {
                return freqA - freqB;
            }

            return b - a;
        });

        for(int i=0;i<nums.length;i++) {
            nums[i] = arr[i];
        }

        return nums;
    }
}
