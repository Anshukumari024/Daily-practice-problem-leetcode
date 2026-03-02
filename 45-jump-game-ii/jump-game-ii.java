class Solution {
    Integer[] dp;

    public int jump(int[] nums) {
        dp = new Integer[nums.length];
        return solve(nums, 0);
    }

    public int solve(int[] nums, int idx) {
        if (idx >= nums.length - 1) return 0;

        if (dp[idx] != null) return dp[idx];

        int min = 9999999;

        for (int i = 1; i <= nums[idx]; i++) {
            if (idx + i < nums.length) {
                min = Math.min(min, 1 + solve(nums, idx + i));
            }
        }

        return dp[idx] = min;
    }
}