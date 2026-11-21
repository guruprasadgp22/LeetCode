class Solution {
    List<List<Integer>> adj;
    int n;
    int[] lastSeenNode;
    int[] res;
    public int[] findSubtreeSizes(int[] parent, String s) {
        n = s.length();
        adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=1;i<n;i++){
            int v = i;
            int u = parent[i];
            adj.get(u).add(v);
        }

        lastSeenNode = new int[26];
        Arrays.fill(lastSeenNode, -1);
        res = new int[n];
        Arrays.fill(res, 1);

        DFS(0, s, parent);
        return res;
    }

    private void DFS(int currNode, String s, int[] parent) {
        int index = s.charAt(currNode) - 'a';
        int nearestAncestor = lastSeenNode[index];
        lastSeenNode[index] = currNode;

        for(int child: adj.get(currNode)) {
            DFS(child, s, parent);
        }

        lastSeenNode[index] = nearestAncestor;
        if(currNode != 0) {
            int newParent = parent[currNode];
            if(nearestAncestor != -1) {
                newParent = nearestAncestor;
            }
            parent[currNode] = newParent;
            res[newParent] += res[currNode];
        }
    }
}
