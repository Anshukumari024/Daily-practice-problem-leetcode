class Solution {
    static final int MOD = 1_000_000_007;

    public int countTexts(String pressedKeys) {
        int n = pressedKeys.length();
        long[] dp = new long[n + 1];
        dp[n] = 1; 
        for (int i = n - 1; i >= 0; i--) {
            char ch = pressedKeys.charAt(i);
            int maxPress = (ch == '7' || ch == '9') ? 4 : 3;
            long ways = 0;
            for (int j = i; j < n && j < i + maxPress; j++) {
                if (pressedKeys.charAt(j) != ch) break;
                ways = (ways + dp[j + 1]) % MOD;
            }
            dp[i] = ways;
        }

        return (int) dp[0];
    }
}
