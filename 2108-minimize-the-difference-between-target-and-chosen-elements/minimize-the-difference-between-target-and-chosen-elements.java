class Solution {
    int ans = Integer.MAX_VALUE;
    int target;
    boolean[][] visited;

    public int minimizeTheDifference(int[][] mat, int target) {
        this.target = target;
        this.visited = new boolean[mat.length][5000];
        dfs(mat, 0, 0);
        return ans;
    }

    private void dfs(int[][] mat, int row, int sum) {
        if (row == mat.length) {
            ans = Math.min(ans, Math.abs(sum - target));
            return;
        }
        if (visited[row][sum]) return;
        visited[row][sum] = true;
        for (int val : mat[row]) {
            dfs(mat, row + 1, sum + val);
        }
    }
}
