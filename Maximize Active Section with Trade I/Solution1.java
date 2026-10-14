class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int activeCount = 0;
        ArrayList<Integer> inActiveCount = new ArrayList<>();
        int i=0;
        while(i < n) {
            if(s.charAt(i) == '0') {
                int start = i;
                while(i < n && s.charAt(i) == '0') {
                    i++;
                }

                inActiveCount.add(i-start);
            } else {
                i++;
                activeCount++;
            }
        }

        int maxSum = 0;
        for(int j=1;j<inActiveCount.size();j++) {
            maxSum = Math.max(maxSum, inActiveCount.get(j-1) + inActiveCount.get(j));
        }

        return maxSum + activeCount;
    }
}
