class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        HashMap<Integer, Integer> frequ = new HashMap<>();
        
        for(int ele: nums) {
            frequ.put(ele, frequ.getOrDefault(ele, 0) + 1);
        }

        int dominant = -1;
        for(Map.Entry<Integer, Integer> entry: frequ.entrySet()) {
            if(entry.getValue() * 2 > n) {
                dominant = entry.getKey();
            }
        }

        int totalCount = frequ.get(dominant);
        int leftCount = 0;

        for(int i=0;i<n;i++) {
            if(nums.get(i) == dominant) {
                leftCount++;
            }
            int leftLength = i + 1;
            int rightLength = n - leftLength;
            int rightCount = totalCount - leftCount;

            if(leftCount * 2 > leftLength && rightCount * 2 > rightLength){
                return i;
            }
        }

        return -1;
    }
}
