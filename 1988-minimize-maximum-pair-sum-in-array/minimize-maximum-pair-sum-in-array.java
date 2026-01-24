class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int l=0;
        int r=nums.length-1;
        int m=0;
        while(l<r){
            m=Math.max(m,nums[l]+nums[r]);
            l++;
            r--;
        }
        return m;
        
    }
}