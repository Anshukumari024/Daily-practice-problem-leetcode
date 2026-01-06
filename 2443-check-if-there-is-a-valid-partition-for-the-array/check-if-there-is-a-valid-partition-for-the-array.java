class Solution {
    public boolean validPartition(int[] nums) {
        Boolean[] dp=new Boolean[nums.length+1];
        return solve(0,nums,dp);
        
    }
    public boolean solve(int i,int[] nums,Boolean[] dp){
        if(i>=nums.length) return true;
        boolean result=false;
        if(dp[i]!=null) return dp[i];
        if(nums.length-i>=2 && nums[i]==nums[i+1]) {
             result=solve(i+2,nums,dp);
            if(result) return dp[i]=true;
        }
        if(nums.length-i>=3 && nums[i]==nums[i+1]  && nums[i+1]==nums[i+2]){
             result=solve(i+3,nums,dp);
            if(result) return dp[i]=true;
        }
        if(nums.length-i>=3 && nums[i+1]-nums[i]==1 && nums[i+2]-nums[i+1]==1){
             result=solve(i+3,nums,dp);
            if(result) return dp[i]=true;
        }
        return dp[i]=result;
    }
}