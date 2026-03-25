class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        long sum=0;
        long[] h=new long[n];
        int idx=0;
        for(int i=0;i<n;i++){
            sum=0;
            for(int j=0;j<m;j++){
                sum+=grid[i][j];
            }
            if(i==0) h[idx]=sum;
            else h[idx]=sum+h[idx-1];
            idx++;
        }
        idx=0;
        long[] v=new long[m];
        for(int i=0;i<m;i++){
            sum=0;
            for(int j=0;j<n;j++){
                sum+=grid[j][i];
            }
            if(i==0) v[idx]=sum;
            else v[idx]=sum+v[idx-1];
            idx++;
        }
        for(int i=0;i<n-1;i++){
            if(h[i]==(h[n-1]-h[i])) return true;
        }
        for(int i=0;i<m-1;i++){
            if(v[i]==(v[m-1]-v[i])) return true;
        }
        return false;
    }
}