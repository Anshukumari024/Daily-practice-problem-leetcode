class Solution {
    public int maxOperations(int[] nums) {
        int[][] dp=new int[nums.length][nums.length];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        int f_o=solve(nums,0,nums.length-1,nums[0]+nums[1],dp);
        for(int[] arr:dp) Arrays.fill(arr,-1);
        int s_o=solve(nums,0,nums.length-1,nums[0]+nums[nums.length-1],dp);
        for(int[] arr:dp) Arrays.fill(arr,-1);
        int t_o=solve(nums,0,nums.length-1,nums[nums.length-1]+nums[nums.length-2],dp);
        return Math.max(f_o,Math.max(s_o,t_o));
    }
    public int solve(int[] nums,int l,int r,int t,int[][] dp){
        if(l>=r) return 0;
        if(dp[l][r]!=-1) return dp[l][r];
        int ans=0;
        if(nums[l]+nums[r]==t) {
            ans=Math.max(ans,1+solve(nums,l+1,r-1,t,dp));
        }
        if(nums[l]+nums[l+1]==t){
            ans=Math.max(ans,1+solve(nums,l+2,r,t,dp));
        }
        if(nums[r]+nums[r-1]==t){
            ans=Math.max(ans,1+solve(nums,l,r-2,t,dp));
        }
        return dp[l][r]=ans;
    }
}