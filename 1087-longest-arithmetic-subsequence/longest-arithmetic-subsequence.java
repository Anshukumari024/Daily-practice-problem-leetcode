class Solution {
    int[][] dp;
    public int longestArithSeqLength(int[] nums) {
        dp=new int[1001][1003];
        for(int[] a:dp) Arrays.fill(a,-1);
        int n=nums.length;
        if(n<=2) return n;
        int ans=0;
        int d=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<n;j++){
                d=nums[j]-nums[i];
                ans=Math.max(ans,2+solve(nums,i,d));
            }
        }
        return ans;
    }
    public int solve(int[] nums,int i,int d){
        if(i<0) return 0;
        if(dp[i][d+501]!=-1) return dp[i][d+501];
        int an=0;
        for(int k=i-1;k>=0;k--){
            if(nums[i]-nums[k]==d){
                an=Math.max(an,1+solve(nums,k,d));
            }
        }
        return dp[i][d+501]=an;
    }
}