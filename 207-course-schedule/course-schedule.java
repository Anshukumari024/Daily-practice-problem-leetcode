class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        List<List<Integer>> adj=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        int[] in=new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            int course=pre[0];
            int preq=pre[1];
            in[course]++;
            adj.get(preq).add(course);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(in[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            ans.add(curr);

            for(int neigh:adj.get(curr)){
                in[neigh]--;
                if(in[neigh]==0) q.add(neigh);
            }
        }
        return ans.size()==n;
        
    }
}