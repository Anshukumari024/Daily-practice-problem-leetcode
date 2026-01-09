class Solution {
    public int maximumLength(int[] nums, int k) {
        int[][] dp=new int[k][nums.length];
        for(int[] arr:dp){
            Arrays.fill(arr,1);
        }
        int maxlen=1;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                int mod=(nums[i]+nums[j])%k;
                dp[mod][i]=Math.max(dp[mod][i],1+dp[mod][j]);
                maxlen=Math.max(dp[mod][i],maxlen);
            }
        }
        return maxlen;
    }
}