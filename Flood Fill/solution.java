class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orgColor = image[sr][sc];
        filling(image, sr, sc, color, orgColor);
        return image;
    }

    private void filling(int[][] arr, int u, int v, int col, int org) {
        if(u < 0 || v < 0 || u >= arr.length || v >= arr[u].length || arr[u][v] != org || arr[u][v] == col) {
            return;
        }

        arr[u][v] = col;
        filling(arr, u-1, v, col, org);
        filling(arr, u, v+1, col, org);
        filling(arr, u+1, v, col, org);
        filling(arr, u, v-1, col, org);
    }
}
