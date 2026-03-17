class Solution {
    static int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int[] ans=new int[2];
        int n=edges.length;
        parent=new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }
        for(int[] edge:edges){
            int x=edge[0];
            int y=edge[1];
            if(find(x)==find(y)){
                ans=edge;
            }
            else{
                union(x,y);
            }
        }
        return ans;
        
    }
     public static int find(int x){
            if(parent[x]!=x){
                parent[x]=find(parent[x]);
            }
            return parent[x];
    }
    public static void union(int x,int y){
            parent[find(x)]=find(y);
    }
}