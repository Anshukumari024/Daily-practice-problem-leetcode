class Solution {
    public int minLength(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        long distinctSum = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            int val = nums[right];
            freq.put(val, freq.getOrDefault(val, 0) + 1);
            if (freq.get(val) == 1) {
                distinctSum += val;
            }
            while (distinctSum >= k) {
                ans = Math.min(ans, right - left + 1);

                int remove = nums[left];
                freq.put(remove, freq.get(remove) - 1);
                if (freq.get(remove) == 0) {
                    distinctSum -= remove;
                }
                left++;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
