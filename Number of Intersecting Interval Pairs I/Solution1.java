class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        
        int count = 0;

        for(int i=1;i<intervals.length;i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            for(int j=0;j<i;j++) {
                int a = intervals[j][0];
                int b = intervals[j][1];

                if(b >= start) {
                    count++;
                }
            }
        }

        return count;
    }
}
