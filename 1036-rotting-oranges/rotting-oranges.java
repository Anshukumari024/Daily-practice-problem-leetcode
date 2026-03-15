class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q= new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int f=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    f++;
                }
            }
        }
        if(f==0) return 0;
        int t=0;
        int[][] dir={{-1,0},{0,-1},{1,0},{0,1}};
        while(!q.isEmpty()){
            int s=q.size();
            boolean isrot=false;
            for(int i=0;i<s;i++){
                int[] rv=q.poll();
                int r=rv[0];
                int c=rv[1];
                for(int[] d:dir){
                    int nr=r+d[0];
                    int nc=c+d[1];
                    if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        f--;
                        q.add(new int[]{nr,nc});
                        isrot=true;
                    }
                }
            }
            if(isrot) t++;

        }
        return f==0? t:-1;
        
    }
}