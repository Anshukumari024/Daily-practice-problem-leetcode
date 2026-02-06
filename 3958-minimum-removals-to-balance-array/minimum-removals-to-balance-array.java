class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            while(nums[i]> (long)nums[j]*k){
                j++;
            }
            l=Math.max(l,i-j+1);
        }
        return nums.length-l;
    }
}