class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] vis=new boolean[n];
        vis[source]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(source);
        while(!q.isEmpty()){
            int rv=q.poll();
            if(rv==destination) return true;
            if(!vis[rv]) vis[rv]=true;

            for(int neigh:graph.get(rv)){
                if(!vis[neigh]) {
                    vis[neigh]=true;
                    q.offer(neigh);
                }
            }
        }
        return false;
    }
}