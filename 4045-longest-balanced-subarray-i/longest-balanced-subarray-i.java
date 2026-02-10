class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            int even=0;
            int odd=0;

            for (int j = i; j < n; j++) {
                if(!set.contains(nums[j])){
                    set.add(nums[j]);
                    if (nums[j] % 2 == 0) {
                        even++;
                    } else {
                        odd++;
                    }
                }

                    if (even == odd) {
                        ans = Math.max(ans, j - i + 1);
                    }
                
            }
        }
        return ans;
    }
}