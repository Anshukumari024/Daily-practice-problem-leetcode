class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int MOD = 1_000_000_007;

        long sum = 0;
        for (int x : arr) sum += x;
        long curr = 0, maxSub = 0;
        for (int x : arr) {
            curr = Math.max(0, curr + x);
            maxSub = Math.max(maxSub, curr);
        }
        long prefix = 0, maxPrefix = 0;
        for (int x : arr) {
            prefix += x;
            maxPrefix = Math.max(maxPrefix, prefix);
        }
        long suffix = 0, maxSuffix = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            suffix += arr[i];
            maxSuffix = Math.max(maxSuffix, suffix);
        }
        if (k == 1) {
            return (int)(maxSub % MOD);
        }
        long ans;
        if (sum > 0) {
            ans = Math.max(
                maxSub,
                maxSuffix + maxPrefix + (long)(k - 2) * sum
            );
        } else {
            ans = Math.max(
                maxSub,
                maxSuffix + maxPrefix
            );
        }

        return (int)(ans % MOD);
    }
}
