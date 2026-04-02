class Solution {
    int an1=0;
    int an2=0;
    Integer[][][] dp;
    public int maximumAmount(int[][] coins) {
        dp=new Integer[coins.length][coins[0].length][3];
        return solve(coins,0,0,2);
    }
    public int solve(int[][] coins,int i,int j,int k){
        if(i>=coins.length || j>=coins[0].length ) return Integer.MIN_VALUE;
        if(dp[i][j][k]!=null) return dp[i][j][k];
        int v=coins[i][j];
        if(i==coins.length-1 && j==coins[0].length-1){
            if(k>0 && v<0) return 0;
            return v;
        }
        int take=Integer.MIN_VALUE;
        int skip=Integer.MIN_VALUE;
        int d=solve(coins,i+1,j,k);
        int r=solve(coins,i,j+1,k);
        int ans=Math.max(d,r);
        if(ans!=Integer.MIN_VALUE){
            take=ans+v;
        }
        if(k>0 && v<0){
            d=solve(coins,i+1,j,k-1);
            r=solve(coins,i,j+1,k-1);
            skip=Math.max(d,r);
        }
        return dp[i][j][k]=Math.max(skip,take);
    }
}