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
            graph.get(u).add(new Pair(v, w));        // forward
            graph.get(v).add(new Pair(u, 2 * w));    // backward
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        boolean[] visited = new boolean[n];

        PriorityQueue<Pair> pq =
            new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int u = cur.node;
            int d = cur.cost;

            // 🔴 already visited → skip
            if (visited[u]) continue;

            // 🔒 lock this node forever
            visited[u] = true;

            if (u == n - 1) return d; // early exit

            for (Pair nei : graph.get(u)) {
                int v = nei.node;
                if (!visited[v] && d + nei.cost < dist[v]) {
                    dist[v] = d + nei.cost;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        return -1;
    }
}
