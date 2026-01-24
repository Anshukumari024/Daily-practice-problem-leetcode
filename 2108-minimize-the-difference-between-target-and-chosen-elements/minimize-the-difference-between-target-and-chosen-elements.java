class Solution {
    int ans=Integer.MAX_VALUE;
    int[][] dp;
    public int minimizeTheDifference(int[][] mat, int target) {
        dp=new int[5000][5000];
        solve(mat,target,0,0);
        return ans;
        
    }
    public void solve(int[][] mat,int target,int r,int sum){
        if(r==mat.length){
            ans=Math.min(ans,Math.abs(sum-target));
            return;
        }
        if(dp[r][sum] !=0) return;
        dp[r][sum]=1;
        if(r>mat.length) return;
        for(int val:mat[r]){
            solve(mat,target,r+1,sum+val);
        }


    }
}