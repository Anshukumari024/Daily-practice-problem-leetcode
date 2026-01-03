class Solution {
    List<Integer>[] tree;
    int[] amount;
    int[] bobTime;
    boolean[] visited;
    int ans = Integer.MIN_VALUE;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        this.amount = amount;

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();

        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }
        bobTime = new int[n];
        Arrays.fill(bobTime, Integer.MAX_VALUE);
        findBobPath(bob, -1, 0);
        visited = new boolean[n];
        dfsAlice(0, -1, 0, 0);

        return ans;
    }
    public boolean findBobPath(int node, int parent, int time) {
        if (node == 0) {
            bobTime[node] = time;
            return true;
        }

        for (int nei : tree[node]) {
            if (nei == parent) continue;
            if (findBobPath(nei, node, time + 1)) {
                bobTime[node] = time;
                return true;
            }
        }
        return false;
    }

    public void dfsAlice(int node, int parent, int time, int profit) {
        visited[node] = true;
        if (time < bobTime[node]) {
            profit += amount[node];
        } else if (time == bobTime[node]) {
            profit += amount[node] / 2;
        }

        boolean isLeaf = true;
        for (int nei : tree[node]) {
            if (nei != parent && !visited[nei]) {
                isLeaf = false;
                dfsAlice(nei, node, time + 1, profit);
            }
        }

        if (isLeaf) {
            ans = Math.max(ans, profit);
        }
    }
}
