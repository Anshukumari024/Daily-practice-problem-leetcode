class Solution {
    public boolean canFinish(int numCourses, int[][] p) {
        int n=p.length;
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] in=new int[numCourses];
        for(int i=0;i<n;i++){
            int a=p[i][0];
            int b=p[i][1];
            in[a]++;
            graph.get(b).add(a);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<in.length;i++){
            if(in[i]==0) q.add(i);
        }
        int c=0;
        while(!q.isEmpty()){
            int rv=q.poll();
            c++;
            for(int neig:graph.get(rv)){
                in[neig]--;
                if(in[neig]==0) q.add(neig);
            }
        }
        return c==numCourses;
    }
}