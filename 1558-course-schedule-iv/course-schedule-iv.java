class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] p, int[][] q) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<p.length;i++){
            int u=p[i][0];
            int v=p[i][1];
            graph.get(u).add(v);
        }
        boolean flag=false;
        List<Boolean> ans=new ArrayList<>();
        for(int i=0;i<q.length;i++){
            flag=false;
            int src=q[i][0];
            int des=q[i][1];
            Queue<Integer> qu=new LinkedList<>();
            qu.add(src);
            boolean[] vi=new boolean[n];
            vi[src]=true;
            while(!qu.isEmpty()){
                int rv=qu.poll();
                if(rv==des) {
                    flag=true;
                    break;
                }
                for(int neig:graph.get(rv)){
                    if(!vi[neig]){
                        qu.add(neig);
                        vi[neig]=true;
                    }
                }

            }
            ans.add(flag);
        }
        return ans;
    }
}