class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int a=times[i][0];
            int b=times[i][1];
            int c=times[i][2];
            graph.get(a).add(new int[] {b,c});
        }
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> (a[1]-b[1]));
        pq.add(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] rv=pq.poll();
            int node=rv[0];
            int cost=rv[1];
            for(int[] neig:graph.get(node)){
                int next=neig[0];
                int ncost=neig[1];
                if(cost+ncost < dist[next]){
                    dist[next]=cost+ncost;
                    pq.add(new int[]{next,cost+ncost});
                }
            }

        }
        int ans=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            ans=Math.max(ans,dist[i]);
        }
        return ans;
    }
}