class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : prerequisites){
            graph.get(edge[0]).add(edge[1]);
        }
        
        List<Boolean> ans = new ArrayList<>();
        for(int[] q : queries){
            int start = q[0];
            int target = q[1];
            
            ans.add(bfs(start, target, graph, numCourses));
        }
        
        return ans;
    }
    
    private boolean bfs(int start, int target, List<List<Integer>> graph, int n){
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        queue.offer(start);
        visited[start] = true;
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            
            if(node == target) return true;
            
            for(int neighbor : graph.get(node)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        
        return false;
    }
}