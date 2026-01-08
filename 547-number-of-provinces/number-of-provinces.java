class Solution {
    public int findCircleNum(int[][] isConnected) {
        int p=0;
        int n=isConnected.length;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
            dfs(i,isConnected,visited,n);
            p++;
            }
        }
        return p;
        
    }
    public void dfs(int i, int[][] isConnected,boolean[] visited,int n){
        visited[i]=true;
        for(int j=0;j<n;j++){
            if(isConnected[i][j]==1 && !visited[j]){
                dfs(j,isConnected,visited,n);
            }
        }
    }
}