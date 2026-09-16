class Solution {
    public int countSpecialIntegers(int[] nums) {
        int result = 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for(Map.Entry<Integer, ArrayList<Integer>> entry: map.entrySet()) {
            ArrayList<Integer> ans = entry.getValue();
            if(ans.size() >= 3) {
                int key = entry.getKey();
                boolean isSame = true;
                int same = ans.get(1) - ans.get(0);
                for(int i=1;i<ans.size()-1;i++) {
                    if(same != (ans.get(i+1) - ans.get(i))) {
                        isSame = false;
                        break;
                    }
                }

                if(isSame) {
                    result++;
                }

            }
        }

        return result;
    }
}
