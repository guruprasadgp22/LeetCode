class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int sum = 0;

        for(int i=0;i<nums.length;i++) {
            sum += nums[i];

            int remainder = (sum % k + k) % k;

            if(map.containsKey(remainder)) {
                count += map.get(remainder);
            }

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        return count;
    }
}
