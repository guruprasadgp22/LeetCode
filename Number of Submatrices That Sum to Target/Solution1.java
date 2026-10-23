class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
            System.out.println(Arrays.toString(matrix[i]));
        }

        int count = 0;

        for (int start_Col = 0; start_Col < n; start_Col++) {
            for (int j = start_Col; j < n; j++) {
                int currSum = 0;
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                for (int i = 0; i < m; i++) {
                    currSum += matrix[i][j] - (start_Col > 0 ? matrix[i][start_Col - 1] : 0);
                    if (map.containsKey(currSum - target)) {
                        count += map.get(currSum - target);
                    }
                    map.put(currSum, map.getOrDefault(currSum, 0) + 1);
                }
            }
        }

        return count;
    }
}
