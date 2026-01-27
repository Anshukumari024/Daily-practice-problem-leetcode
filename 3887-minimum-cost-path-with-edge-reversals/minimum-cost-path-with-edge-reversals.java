class Solution {
    static class Pair {
        int node;
        int cost;
        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    public int minCost(int n, int[][] edges) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            graph.get(u).add(new Pair(v, w));       
            graph.get(v).add(new Pair(u, 2 * w));    
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Pair> pq =
            new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int u = cur.node;
            int d = cur.cost;

            if (d > dist[u]) continue;

            for (Pair nei : graph.get(u)) {
                int v = nei.node;
                int newCost = d + nei.cost;

                if (newCost < dist[v]) {
                    dist[v] = newCost;
                    pq.add(new Pair(v, newCost));
                }
            }
        }

        return dist[n - 1] == Integer.MAX_VALUE ? -1 : dist[n - 1];
    }
}
