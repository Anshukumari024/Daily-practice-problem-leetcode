class Solution {
    public List<Integer> goodDaysToRobBank(int[] nums, int time) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();

        if (time == 0) {
            for (int i = 0; i < n; i++) res.add(i);
            return res;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1])
                left[i] = left[i - 1] + 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1])
                right[i] = right[i + 1] + 1;
        }
        for (int i = time; i < n - time; i++) {
            if (left[i] >= time && right[i] >= time) {
                res.add(i);
            }
        }

        return res;
    }
}
