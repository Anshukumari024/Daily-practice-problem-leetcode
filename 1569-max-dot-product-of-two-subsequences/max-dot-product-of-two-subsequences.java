class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp=new int[501][501];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        }
        return solve(nums1,nums2,0,0,dp);


    }
    public int solve(int[] nums1,int[] nums2,int i,int j,int[][] dp){
        if(i>=nums1.length || j>=nums2.length) return Integer.MIN_VALUE/2;
        if(dp[i][j]!=Integer.MIN_VALUE) return dp[i][j];

        int val=nums1[i]*nums2[j];
        int t_i_j=(nums1[i]*nums2[j])+solve(nums1,nums2,i+1,j+1,dp);
        int take_i=solve(nums1,nums2,i,j+1,dp);
        int take_j=solve(nums1,nums2,i+1,j,dp);
        return dp[i][j]=Math.max(val,Math.max(t_i_j,Math.max(take_i,take_j)));
    }
}