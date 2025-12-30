class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] dist=new int[m][n];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    dist[i][j]=0;
                    q.add(new Pair(i,j));
                }
                else{
                    dist[i][j]=-1;
                }
            }
        }
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};

        while(!q.isEmpty()){
            Pair node =q.poll();
            for(int d=0;d<4;d++){
                int nx=node.r+dx[d];
                int ny=node.c+dy[d];
                if(nx>=0 && nx<m && ny>=0 && ny<n && dist[nx][ny]== -1){
                    dist[nx][ny]=dist[node.r][node.c]+1;
                    q.add(new Pair(nx,ny));
                }
            }

        }
        return dist;
    }
    class Pair{
        int r;
        int c;
        Pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
}