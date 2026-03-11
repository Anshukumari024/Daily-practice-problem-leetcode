class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int e:nums){
            set.add(e);
        }
        int ans=0;
        // int key=1;
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int c=0;
                int key=nums[i];
                while(set.contains(key)){
                    set.remove(key);
                    c++;
                    key++;
                    
                }
                ans=Math.max(ans,c);
            }
           
        }
        return ans;
        
    }
}