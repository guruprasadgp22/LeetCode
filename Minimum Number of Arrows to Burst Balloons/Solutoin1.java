class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if(a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        int[] prev = points[0];
        int i = 1;
        int n = points.length;
        int count = 0;

        while(i < n) {
            if(points[i][0] > prev[1]) {
                count++;
                prev = points[i];
            } else {
                prev[0] = Math.max(prev[0], points[i][0]);
                prev[1] = Math.min(prev[1], points[i][1]);
            }
            i++;
        }
        return count + 1;
    }
}
