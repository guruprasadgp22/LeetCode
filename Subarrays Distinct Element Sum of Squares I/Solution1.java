class Solution {
    public int sumCounts(List<Integer> nums) {
        int total = 0;
        int n = nums.size();
        for(int i=0;i<n;i++) {
            int[] freq = new int[101];
            for(int j=i;j<n;j++) {
                freq[nums.get(j)]++;

                int count = 0;
                for(int ele: freq) {
                    if(ele > 0) {
                        count++;
                    }
                }

                total += (count * count);
            }
        }

        return total;
    }
}
