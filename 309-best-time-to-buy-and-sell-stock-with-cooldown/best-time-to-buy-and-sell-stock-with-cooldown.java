class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];
        for(int[] a:dp) Arrays.fill(a,-1);
        return solve(prices,0,1,dp);
    }
     public static int solve(int[] prices,int i,int buy,int[][] dp){
        if(i>=prices.length) return 0;
        if(dp[i][buy] != -1) return dp[i][buy];
        if(buy==1){
            int take=-prices[i]+solve(prices,i+1,0,dp);
            int skip=solve(prices,i+1,1,dp);
            return dp[i][buy]=Math.max(take,skip);
        }
        else{
            int sell=prices[i]+solve(prices,i+2,1,dp);
            int skip=solve(prices,i+1,0,dp);
            return dp[i][buy]=Math.max(sell,skip);
        }
    }
}