class Solution {
    public int findCenter(int[][] edges) {
        int x = edges[0][0];
        int y = edges[0][1];
        int u = edges[1][0];
        int v = edges[1][1];

        if(x == u){
            return x;
        } else if(x == v){
            return x;
        } else {
            return y;
        }
    }
}
