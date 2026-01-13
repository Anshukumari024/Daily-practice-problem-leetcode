class Solution {
    public long perfectPairs(int[] nums) {
         long[] arr= new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Math.abs((long) nums[i]);
        }
        Arrays.sort(arr);
        long c = 0;
        int n = arr.length;

        int j = 0;
        for (int i= 0; i < n; i++) {
            while (j<n && arr[j]<= 2*arr[i]) {
                j++;
            }
            c+=(j-i-1);
        }

        return c;
    }
}