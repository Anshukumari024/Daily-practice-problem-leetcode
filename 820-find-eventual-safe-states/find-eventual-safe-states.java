class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> rev=new ArrayList<>();
        int n=graph.length;
        for(int i=0;i<n;i++){
            rev.add(new ArrayList<>());
        }
        int[] out=new int[n];
        for(int i=0;i<graph.length;i++){
            for(int e:graph[i]){
                rev.get(e).add(i);
                out[i]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(out[i]==0) q.add(i);
        }
        int[] safe=new int[n];
        while(!q.isEmpty()){
            int rv=q.poll();
            safe[rv]++;
            for(int neig:rev.get(rv)){
                out[neig]--;
                if(out[neig]==0){
                    q.add(neig);
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(safe[i]!=0) ans.add(i);
        }
        return ans;

    }
}