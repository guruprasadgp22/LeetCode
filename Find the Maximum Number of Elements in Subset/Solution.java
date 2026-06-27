class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele: nums) {
           map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        int max = 0;

        if(map.containsKey(1)) {
            int count = map.get(1);
            if(count % 2 == 0) {
                count--;
            }

            max = Math.max(max, count);
        }

        for(int key: map.keySet()) {
            if(key == 1) {
                continue;
            }

            int currentLen = 0;
            int curr = key;

            while(curr <= 1000000000L && map.getOrDefault((int)curr, 0) >= 2) {
                curr *= curr;
                currentLen += 2;
            }

            if(curr <= 1000000000L && map.getOrDefault((int)curr, 0) > 0) {
                currentLen += 1;
            } else {
                currentLen -= 1;
            }

            max = Math.max(max, currentLen);
        }

        return max;
    }
}
