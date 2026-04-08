class Solution {
    long[] dp;
    public long mostPoints(int[][] questions) {
        dp=new long[questions.length+1];
        Arrays.fill(dp,-1);
        return (long)solve(questions,0);
    }
    public long solve(int[][] questions,int i){
        if(i>=questions.length) return 0L;
        if(dp[i]!=-1) return dp[i];
        long take=questions[i][0]+solve(questions,i+1+questions[i][1]);
        long skip=solve(questions,i+1);
        return dp[i]=(Math.max(take,skip));
    }
}