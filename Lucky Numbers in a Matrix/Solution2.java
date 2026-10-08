class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int rowMinMax = Integer.MIN_VALUE;
        for(int i=0;i<m;i++) {
            int rowMin = Integer.MAX_VALUE;
            for(int j=0;j<n;j++) {
                rowMin = Math.min(rowMin, matrix[i][j]);
            }
            rowMinMax = Math.max(rowMinMax, rowMin);
        }

        int colMaxMin = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            int colMax = Integer.MIN_VALUE;
            for(int j=0;j<m;j++) {
                colMax = Math.max(colMax, matrix[j][i]);
            }
            colMaxMin = Math.min(colMaxMin, colMax);
        }

        if(colMaxMin == rowMinMax) {
            List<Integer> res = new ArrayList<>();
            res.add(colMaxMin);
            return res;
        }

        return new ArrayList<>();
    }
}
