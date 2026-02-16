class Solution {
    public long countSubarrays(int[] nums, int k) {
        int l=0;
        int r=0;
        int c=0;
        int max=nums[0];
        for(int i:nums){
            if(i>max) max=i;
        }
        long co=0;
        for(r=0;r<nums.length;r++){
            if(nums[r]==max) c++;
            while(c>=k){
                co+=(nums.length-r);
                
                if(nums[l]==max) c--;
                l++;
            }
            
        }
        return co;
        
    }
}