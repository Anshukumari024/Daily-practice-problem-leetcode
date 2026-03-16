class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.add(new int[] {0,0,0});
        int[][] dist=new int[n][m];
        for(int[] a:dist) Arrays.fill(a,Integer.MAX_VALUE);
        dist[0][0]=0;
        int[][] dir={{-1,0},{0,-1},{1,0},{0,1}};
        while(!pq.isEmpty()){
            int[] rv=pq.poll();
            int e=rv[0];
            int r=rv[1];
            int c=rv[2];
            if(r==n-1 && c==m-1) return e;
            for(int[] d:dir){
                int nr=rv[1]+d[0];
                int nc=rv[2]+d[1];
               if(nr>=0 && nc>=0 && nr<n && nc<m){
                    int ne=Math.max(e,Math.abs(heights[r][c]-heights[nr][nc]));
                    if(ne<dist[nr][nc]){
                        dist[nr][nc]=ne;
                        pq.add(new int[]{ne,nr,nc});
                    }
               }
            }
        }
        return 0;
    }
}