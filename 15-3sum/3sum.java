class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ll=new ArrayList<>();
        int l=0;
        int h=0;
        for(int i=0;i<nums.length-2;i++){
             l=i+1;
             h=nums.length-1;
             if(i>0 && nums[i]==nums[i-1]) continue;
            while(l<h){
                int sum=nums[l]+nums[h]+nums[i];
                if(sum==0){
                    ll.add(Arrays.asList(nums[i],nums[l],nums[h]));
                    l++;
                    h--;
                    while(l<h && nums[l]==nums[l-1]) l++;
                    while(l<h && nums[h]==nums[h+1]) h--;
                }
               if(sum<0) l++;
               if(sum>0) h--;
            }
        }
        return ll;
    }
}