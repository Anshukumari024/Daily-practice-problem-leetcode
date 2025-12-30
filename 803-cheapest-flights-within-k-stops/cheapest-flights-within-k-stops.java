class Solution {
    static class Pair {
        int node;
        int cost;
        int stops;
        Pair(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] f : flights) {
            adj.get(f[0]).add(new int[]{f[1], f[2]});
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src, 0, 0));

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            int node = cur.node;
            int cost = cur.cost;
            int stops = cur.stops;
            if (stops > k) continue;
            for (int[] nei : adj.get(node)) {
                int nextNode = nei[0];
                int edgeCost = nei[1];

                if (cost + edgeCost < dist[nextNode]) {
                    dist[nextNode] = cost + edgeCost;
                    q.offer(new Pair(nextNode, dist[nextNode], stops + 1));
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
