import java.util.*;

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Deque<int[]> dq = new ArrayDeque<>();

        // starting cell cost
        dist[0][0] = grid.get(0).get(0);
        dq.offerFirst(new int[]{0, 0});

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n)
                    continue;

                int cost = dist[x][y] + grid.get(nx).get(ny);

                if (cost < dist[nx][ny]) {
                    dist[nx][ny] = cost;

                    if (grid.get(nx).get(ny) == 0)
                        dq.offerFirst(new int[]{nx, ny});
                    else
                        dq.offerLast(new int[]{nx, ny});
                }
            }
        }

        return dist[m - 1][n - 1] <= health - 1;
    }
}
