class Graph {
    int v;
    List<List<Integer>> list;

    Graph(int v) {
        this.v = v;
        list = new ArrayList<>(v);

        for(int i=0;i<v;i++) {
            list.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v) {
        list.get(u).add(v);
    }

    boolean isCycle() {
        boolean[] visited = new boolean[v];
        boolean[] recursive = new boolean[v];

        for(int i=0;i<v;i++) {
            if(!visited[i]) {
                if(DFS(i, visited, recursive)) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean DFS(int source, boolean[] visited, boolean[] recursive) {
        visited[source] = true;
        recursive[source] = true;

        for(int neigh: list.get(source)) {
            if(!visited[neigh]) {
                if(DFS(neigh, visited, recursive)) {
                    return true;
                }
            } else if(recursive[neigh]) {
                return true;
            }
        }

        recursive[source] = false;
        return false;
    }
}
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses);

        for(int i=0;i<prerequisites.length;i++) {
            graph.addEdge(prerequisites[i][0], prerequisites[i][1]);
        }

        return graph.isCycle();
    }
}
