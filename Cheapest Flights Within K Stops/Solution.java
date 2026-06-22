class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        for(int i=0;i<=k;i++) {
            int[] temp = distance.clone();
            for(int[] edge: flights) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if(distance[u] != Integer.MAX_VALUE && temp[v] > distance[u] + w) {
                    temp[v] = distance[u] + w;
                }
            }

            distance = temp;
        }

        return (distance[dst] == Integer.MAX_VALUE)? -1: distance[dst];
    }
}
