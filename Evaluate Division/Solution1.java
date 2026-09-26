class Pair {
    String v;
    double val;

    Pair(String v, double val) {
        this.v = v;
        this.val = val;
    }
}


class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();

        HashMap<String, List<Pair>> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            List<String> ls = equations.get(i);
            String u = ls.get(0);
            String v = ls.get(1);
            double val = values[i];

            map.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair(v, val));
            map.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair(u, 1.0/val));
        }        

        double[] result = new double[queries.size()];
        for(int i=0;i<queries.size();i++) {
            List<String> ls = queries.get(i);
            String src = ls.get(0);
            String dst = ls.get(1);

            if(!map.containsKey(src) || !map.containsKey(dst)) {
                result[i] = -1.0;
                continue;
            }

            if(src.equals(dst)) {
                result[i] = 1.0;
                continue;
            }

            HashSet<String> visited = new HashSet<>();
            result[i] = DFS(src, dst, visited, map, 1.0);
        }

        return result;
    }

    private double DFS(String src, String dst, HashSet<String> visited, HashMap<String, List<Pair>> map, double product){
        if(src.equals(dst)) {
            return product;
        }

        visited.add(src);

        for(Pair next: map.get(src)) {
            String v = next.v;
            double val = next.val;

            if(!visited.contains(v)) {
                double ans = DFS(v, dst, visited, map, product * val);
                if(ans != -1) {
                    return ans;
                }
            }
        }

        return -1.0;
    }
}
