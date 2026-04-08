class Solution {
    static int[][][] dp;
    public int minCost(int[][] grid) {
        dp=new int[grid.length][grid[0].length][1024];
        for(int[][] aa:dp){
            for(int[] a:aa){
                Arrays.fill(a,-1);
            }
        }
        return solve(grid,0,0,0);
        
    }
    public int solve(int[][] grid,int i,int j,int xor){
        if(i>=grid.length || j>=grid[0].length) return Integer.MAX_VALUE;
        xor^=grid[i][j];
        if(dp[i][j][xor] != -1) return dp[i][j][xor];
        if(i==grid.length-1 && j==grid[0].length-1) return xor;
        int d=solve(grid,i+1,j,xor);
        int r=solve(grid,i,j+1,xor);
        return dp[i][j][xor]=Math.min(d,r);
    }
}