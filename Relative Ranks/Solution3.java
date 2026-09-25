class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;

        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> {
            return b[0] - a[0];
        });

        String[] result = new String[n];

        for(int i=0;i<n;i++) {
            int index = arr[i][1];

            if(i == 0) {
                result[index] = "Gold Medal";
            } else if(i == 1) {
                result[index] = "Silver Medal";
            } else if(i == 2) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = String.valueOf(i + 1);
            }
        }

        return result;
    }
}
