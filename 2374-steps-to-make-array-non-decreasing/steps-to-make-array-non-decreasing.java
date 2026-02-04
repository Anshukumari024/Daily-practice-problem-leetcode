class Solution {
    public int totalSteps(int[] nums) {
        Stack<int[]> st = new Stack<>();
        int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int steps = 0;
            while (!st.isEmpty() && nums[i] > st.peek()[0]) {
                steps = Math.max(steps + 1, st.peek()[1]);
                st.pop();
            }
             
            ans = Math.max(ans, steps);
            st.push(new int[]{nums[i], steps});
        }

        return ans;
    }
}
