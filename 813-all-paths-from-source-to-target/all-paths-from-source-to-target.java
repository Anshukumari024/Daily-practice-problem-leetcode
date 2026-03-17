class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        dfs(0,list,ll,graph);
        return list;
    }
    public void dfs(int node,List<List<Integer>> list,List<Integer> ll,int[][] graph){
        ll.add(node);
        if(node==graph.length-1){
            list.add(new ArrayList<>(ll));
        }
        else{
            for(int neig:graph[node]){
                dfs(neig,list,ll,graph);
            }
        }
        ll.remove(ll.size()-1);
    }
}