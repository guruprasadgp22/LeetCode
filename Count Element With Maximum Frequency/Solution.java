class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];

        for(int ele: nums) {
            freq[ele]++;
        }

        int maxFreq = -1;

        for(int ele: freq) {
            maxFreq = Math.max(maxFreq, ele);
        }

        int total = 0;

        for(int ele: freq) {
            if(ele == maxFreq) {
                total += ele;
            }
        }

        return total;
    }
}
