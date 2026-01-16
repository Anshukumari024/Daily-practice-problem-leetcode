class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int e : nums) {
            sum += e;
        }
        long re = Math.abs((long) goal - sum);

        return (int) ((re + limit - 1) / limit); 
    }
}
