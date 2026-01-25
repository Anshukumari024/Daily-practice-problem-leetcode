class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int ans=Integer.MAX_VALUE;
        int ma=0;
        int mi=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-k+1;i++){
            ma=0;
            mi=Integer.MAX_VALUE;
            for(int j=i;j<i+k;j++){
                mi=Math.min(mi,nums[j]);
                ma=Math.max(ma,nums[j]);
            }
            ans=Math.min(ans,ma-mi);
        }
        return ans;
    }
}