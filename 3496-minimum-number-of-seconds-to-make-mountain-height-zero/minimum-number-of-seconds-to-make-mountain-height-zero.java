class Solution {
    public long minNumberOfSeconds(int h, int[] a) {
        int mx = 0;
        for (int t : a) {
            mx = Math.max(mx, t);
        }
        long l = 1;
        long r = (long) mx * h * (h + 1) / 2;
        long ans = 0;
        while (l <= r) {
            long m = l + (r - l) / 2;
            if (ok(m, a, h)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return ans;
    }
    private boolean ok(long m, int[] a, int h) {
        long s = 0;
        for (int t : a) {
            s += (long)(Math.sqrt(2.0 * m / t + 0.25) - 0.5);
            if (s >= h) return true;
        }

        return s >= h;
    }
}