class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            for(int j=i-1;j>=0 && j>=i-3;j--){
                 if (dp[j] == Integer.MAX_VALUE) continue;
                dp[i]=Math.min((costs[i-1]+(j-i)*(j-i))+dp[j],dp[i]);
            }
        }
        return dp[n];

        
    }
}