class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] arr = new long[n]; 

        for (int i = 0; i < n; i++) {
            arr[edges[i]] += i;
        }
        int ans = 0;
        long maxScore = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > maxScore) {
                maxScore = arr[i];
                ans = i;
            }

        }

        return (int)ans;
    }
}