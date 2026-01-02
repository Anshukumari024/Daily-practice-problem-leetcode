class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            int v = edge[1];
            indegree[v]++;
        }
        int champion = -1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                champion = i;
                count++;
            }
        }

        return count == 1 ? champion : -1;
    }
}
