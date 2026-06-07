class Solution {
    public long minEnergy(int n, int brightness, int[][] intervals) {
        Arrays.sort(intervals, (p,q) -> {
           return Long.compare(p[0], q[0]); 
        });

        long aTime = 0;
        long st = intervals[0][0];
        long ed = intervals[0][1];

        for(int k = 1; k < intervals.length; k++) {
            long start = intervals[k][0];
            long end = intervals[k][1];

            if(start <= ed+1) {
                ed = Math.max(ed, end);
            } else {
                aTime += (ed - st + 1);
                st = start;
                ed = end;
            }
        }

        aTime += (ed - st + 1);

        long bulbs = (brightness + 2l)/3l;

        return bulbs * aTime;
    }
}
