class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele: nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        int ans = -1;
        int max = -1;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int key = entry.getKey();
            int freq = entry.getValue();
            if(key % 2 == 0) {
                if(freq > max || (freq == max && key < ans)) {
                    ans = key;
                    max = freq;
                }
            }
        }

        return ans;
    }
}
