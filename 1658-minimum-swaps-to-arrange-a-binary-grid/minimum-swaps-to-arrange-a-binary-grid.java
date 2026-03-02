class Solution {
    public int minSwaps(int[][] grid) {
        int n=grid.length;
        int[] endzero=new int[grid.length];
        for(int i=0;i<n;i++){
            int j=n-1;
            int c=0;
            while(j>=0 && grid[i][j]==0){
                c++;
                j--;
            }
            endzero[i]=c;
        }
        int steps=0;
        for(int i=0;i<n;i++){
            int j=i;
            int need=n-i-1;
            while(j<n && endzero[j]<need) j++;
            if(j==n) return -1;
            steps+=(j-i);

            while(j>i){
                int temp=endzero[j];
                endzero[j]=endzero[j-1];
                endzero[j-1]=temp;
                j--;
            }

        }
        return steps;
    }
}