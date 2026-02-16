class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum=0;
        int s=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            s+=(i*nums[i]);
        }
        int max=s;
        for(int i=1;i<nums.length;i++){
            s=sum+s-(nums.length*nums[nums.length-i]);
            if(max<s) max=s;

        }
        return max;
        
    }
}