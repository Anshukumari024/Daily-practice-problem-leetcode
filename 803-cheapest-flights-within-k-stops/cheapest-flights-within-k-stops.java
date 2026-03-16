class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int a=flights[i][0];
            int b=flights[i][1];
            int c=flights[i][2];
            graph.get(a).add(new int[]{b,c});
        }
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{src,0,0});
        while(!q.isEmpty()){
            int[] rv=q.poll();
            int node=rv[0];
            int cost=rv[1];
            int stops=rv[2];
            if(stops>k) continue;
            for(int[] neig:graph.get(node)){
                int no=neig[0];
                int co=neig[1];
                if(co+cost<dist[no]){
                    dist[no]=cost+co;
                    q.add(new int[]{no,co+cost,stops+1});
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}