class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        
        for(int i=0;i<n;i++){
            if(color[i]!=0) continue;
            Queue<Pair> q=new LinkedList<>();
            q.add(new Pair(i,1));
            color[i]=1;
        
            while(!q.isEmpty()){
                Pair curr=q.poll();
                int no=curr.node;
                int n_c=curr.nodecolor;
                int next_c=-n_c;
                for(int neigh:graph[no]){
                    if(color[neigh]==0){
                        color[neigh]=next_c;
                        q.add(new Pair(neigh,next_c));
                    }
                    else if(color[neigh]==n_c){
                        return false;
                    }
                }

            }
        }
        return true;
    }
    class Pair{
        int node;
        int nodecolor;
        Pair(int node,int nodecolor){
            this.node=node;
            this.nodecolor=nodecolor;
        }
    }
}