class Solution {
    public int countSpecialIntegers(int[] nums) {
        int result = 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for(Map.Entry<Integer, ArrayList<Integer>> entry: map.entrySet()) {
            ArrayList<Integer> ans = entry.getValue();
            if(ans.size() == 3) {
                int key = entry.getKey();

                int first = ans.get(0);
                int second = ans.get(1);
                int third = ans.get(2);

                if(second - first == third - second) {
                    result++;
                }

            }
        }

        return result;
    }
}
