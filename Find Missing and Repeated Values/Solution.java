class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length * grid.length;
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        int naturalSum = (n * (n+1))/2;
        
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                map.put(grid[i][j], map.getOrDefault(grid[i][j], 0) + 1);
            }
        }

        int sum = 0;

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            sum += entry.getKey();
            if(entry.getValue() > 1) {
                ans[0] = entry.getKey();
            }
        }

        ans[1] = naturalSum - sum;

        return ans;
    }
}
