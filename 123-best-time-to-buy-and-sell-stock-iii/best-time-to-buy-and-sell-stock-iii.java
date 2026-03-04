class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp=new int[prices.length][2+1][2];
        for(int[][] a1:dp){
            for(int[] a:a1) Arrays.fill(a,-1);
        }
        return solve(prices,2,0,1,dp);
        
    }
    public static int solve(int[] prices,int k,int i,int buy,int[][][] dp){
        if(i>=prices.length) return 0;
        if(k<=0) return 0;
        if(dp[i][k][buy] != -1) return dp[i][k][buy];
        if(buy==1){
            int take=-prices[i]+solve(prices,k,i+1,0,dp);
            int skip=solve(prices,k,i+1,1,dp);
            return dp[i][k][buy]=Math.max(take,skip);
        }
        else{
            int sell=prices[i]+solve(prices,k-1,i+1,1,dp);
            int skip=solve(prices,k,i+1,0,dp);
            return dp[i][k][buy]=Math.max(sell,skip);
        }
    }
}