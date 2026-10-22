class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int count = 0;
        int n = intervals.length;
        int i = 0;
        int j = 1;
        while(j < n) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            int nextStart = intervals[j][0];
            int nextEnd = intervals[j][1];

            if(currEnd <= nextStart) {
                i = j;
                j++;
            } else if(currEnd <= nextEnd) {
                j++;
                count++;
            } else if(currEnd > nextEnd) {
                i = j;
                j++;
                count++;
            }
        }
        return count;
    }
}
// [1, 2],[1,3],[2,3],[3,4]
