import java.util.*;
class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
         if(n == 1 && m == 1) return 0;
        Queue<int[]> q = new LinkedList<>();

        int[][] visited = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(visited[i], -1);
        }

        q.add(new int[]{0,0,k,0}); // r,c,k_left,steps
        visited[0][0] = k;
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int rem = cur[2];
            int steps = cur[3];

            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr<0 || nc<0 || nr>=n || nc>=m) continue;
                int nk = rem - grid[nr][nc];
                if(nk < 0) continue;
                if(nr == n-1 && nc == m-1) return steps + 1;

                if(visited[nr][nc] >= nk) continue;
                visited[nr][nc] = nk;
                q.add(new int[]{nr,nc,nk,steps+1});
            }
        }

        return -1;
    }
}