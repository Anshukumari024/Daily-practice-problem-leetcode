class Solution {
    static int mod=12345;
    public int[][] constructProductMatrix(int[][] grid) {
        int p=1;
        int[] arr=new int[grid.length*grid[0].length];
        int idx=0;
        for(int[] g:grid){
            for(int a:g){
                arr[idx++]=a%mod;
            }
        }
        int[] pre=new int[arr.length];
        pre[0]=1;
        for(int i=1;i<arr.length;i++){
            pre[i]=(pre[i-1]*arr[i-1])%mod;
        }
        int[] suff=new int[arr.length];
        suff[arr.length-1]=1;
        for(int i=arr.length-2;i>=0;i--){
            suff[i]=(suff[i+1]*arr[i+1])%mod;
        }
        idx=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                grid[i][j]=(pre[idx]*suff[idx]) % mod;
                idx++;
            }
        }
        return grid;
        
    }
}