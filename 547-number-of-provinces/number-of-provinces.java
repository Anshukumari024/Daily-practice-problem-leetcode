class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] vi=new boolean[n+1];
        int c=0;
        for(int i=1;i<=n;i++){
            if(vi[i]) continue;
            c++;
            Queue<Integer> q=new LinkedList<>();
            q.add(i);
            vi[i]=true;
            
            while(!q.isEmpty()){
                int rv=q.poll();
                for(int ii=0;ii<isConnected[rv-1].length;ii++){
                    int neig=isConnected[rv-1][ii];
                     if(neig==1){
                        if(!vi[ii+1])
                            q.add(ii+1);
                            vi[ii+1]=true;
                     }
                }
            } 
        }
        return c;
        
    }
}