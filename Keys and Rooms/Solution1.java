class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        boolean[] visited = new boolean[n];

        DFS(0, visited, rooms);

        for(boolean ele: visited) {
            if(!ele) {
                return false;
            }
        }

        return true;
    }

    private void DFS(int source, boolean[] visited, List<List<Integer>> rooms) {
        visited[source] = true;

        for(int n: rooms.get(source)) {
            if(!visited[n]) {
                DFS(n, visited, rooms);
            }
        }
    }
}
