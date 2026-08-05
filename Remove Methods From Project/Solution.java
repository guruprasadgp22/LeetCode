class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        boolean[] suspecious = new boolean[n];
        int[] inDegree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] x: invocations) {
            int u = x[0];
            int v = x[1];

            adj.get(u).add(v);
            inDegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        suspecious[k] = true;
        queue.add(k);

        while(!queue.isEmpty()) {
            int u = queue.poll();

            for(int v: adj.get(u)) {
                inDegree[v]--;
                if(!suspecious[v]) {
                    suspecious[v] = true;
                    queue.add(v);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        boolean cannotRemove = false;

        for(int i=0;i<n;i++) {
            if(suspecious[i] && inDegree[i] > 0) {
                cannotRemove = true;
                break;
            }

            if(!suspecious[i]) {
                result.add(i);
            }
        }

        if(cannotRemove) {
            List<Integer> ans = new ArrayList<>();
            for(int i=0;i<n;i++) {
                ans.add(i);
            }

            return ans;
        }

        return result;
    }
}
