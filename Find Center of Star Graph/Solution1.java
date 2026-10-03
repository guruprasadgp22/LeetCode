class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        int[] inDegree = new int[n+1];
        for(int[] x: edges) {
            int u = x[0]-1;
            int v = x[1]-1;
            inDegree[u]++;
            inDegree[v]++;
        }

        for(int i=0;i<=n;i++) {
            if(inDegree[i] > 1){
                return i+1;
            }
        }

        return 0;
    }
}
