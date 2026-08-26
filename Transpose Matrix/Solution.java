class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int result[][] = new int[n][m];

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i == j) {
                    result[i][j] = matrix[i][j];
                    continue;
                }

                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }
}
