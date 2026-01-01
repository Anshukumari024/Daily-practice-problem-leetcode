class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1); 
        boolean[] visited = new boolean[n];
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0}); 

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long time = curr[0];
            int node = (int) curr[1];

            if (visited[node]) continue;
            visited[node] = true;
            if (time >= disappear[node]) continue;

            ans[node] = (int) time;
            for (int[] nei : graph[node]) {
                int next = nei[0];
                int weight = nei[1];
                long arri = time + weight;

                if (!visited[next] && arri < disappear[next]) {
                    pq.offer(new long[]{arri, next});
                }
            }
        }

        return ans;
    }
}