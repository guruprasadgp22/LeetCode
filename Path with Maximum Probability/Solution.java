class Pair implements Comparable<Pair> {
    int destination;
    double weight;

    Pair(int destination, double weight) {
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Pair other) {
        return Double.compare(other.weight, this.weight);
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> list = new ArrayList<>();

        for(int i=1;i<=n;i++) {
            list.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];
            list.get(u).add(new Pair(v, w));
            list.get(v).add(new Pair(u, w));
        }

        double[] distance = new double[n];
        PriorityQueue<Pair> queue = new PriorityQueue<>();

        distance[start_node] = 1.0;
        queue.add(new Pair(start_node, 1.0));

        while(!queue.isEmpty()) {
            Pair temp = queue.poll();
            int u = temp.destination;

            if(temp.weight < distance[u]) {
                continue;
            }

            if(u == end_node) {
                return distance[end_node];
            }

            for(Pair v: list.get(u)) {
                if(distance[v.destination] < distance[u] * v.weight) {
                    distance[v.destination] = distance[u] * v.weight;
                    queue.add(new Pair(v.destination, distance[v.destination]));
                }
            }
        }

        return 0;
    }
}
