class Pair {
    int v;
    int w;

    Pair(int v, int w) {
        this.v = v;
        this.w = w;
    }
}

class Tuple {
    int v;
    int w;
    int stops;

    Tuple(int v, int w, int stops) {
        this.v = v;
        this.w = w;
        this.stops = stops;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> graph = new ArrayList<>();

        for(int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] x: flights) {
            int u = x[0];
            int v = x[1];
            int w = x[2];

            graph.get(u).add(new Pair(v, w));
        }

        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(src, 0, -1));

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        while(!queue.isEmpty()) {
            Tuple temp = queue.poll();

            int v = temp.v;
            int weight = temp.w;
            int stops = temp.stops;

            for(Pair a: graph.get(v)) {
                int newW = weight + a.w;

                if(distance[a.v] > newW && stops + 1 <= k) {
                    distance[a.v] = newW;
                    queue.add(new Tuple(a.v, distance[a.v], stops+1));
                }
            }
        }

        if(distance[dst] != Integer.MAX_VALUE) {
            return distance[dst];
        }

        return -1;
    }
}
