class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxOverlap = 0;

        for(int row=-n+1;row<n;row++) {
            for(int col=-n+1;col<n;col++) {
                int count = countOverlaps(row, col, img1, img2);
                maxOverlap = Math.max(maxOverlap, count);
            }
        }

        return maxOverlap;
    }

    private int countOverlaps(int row, int col, int[][] a, int b[][]) {
        int n = b.length;
        int count = 0;

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                int B_i = i + row;
                int B_j = j + col;

                if(B_i < 0 || B_j < 0 || B_i >= n || B_j >= n) {
                    continue;
                }

                if(a[i][j] == 1 && b[B_i][B_j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
