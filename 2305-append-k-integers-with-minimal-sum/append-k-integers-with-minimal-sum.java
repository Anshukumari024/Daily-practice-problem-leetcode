class Solution {
    public long minimalKSum(int[] nums, int k) {
        long p=1;
        long sum=0;
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length){
            if(i>0 && nums[i]==nums[i-1]){
                i++;
                continue;
            }
            else if(nums[i]!=p && k>0){
                sum+=p;
                p++;
                k--;
            }
            else{
                i++;
                p++;
            }
        }
        p=nums[nums.length-1]+1;
        while(k>0){
            sum+=p;
            p++;
            k--;
        }
        return sum;
        
    }
}