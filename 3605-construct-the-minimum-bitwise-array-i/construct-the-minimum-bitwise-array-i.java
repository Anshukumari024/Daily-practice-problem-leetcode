class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans=new int[nums.size()];
        int k=0;
        
        for(int i=0;i<nums.size();i++){
            boolean flag=false;
            for(int x=0;x<nums.get(i);x++){
                if((x | (x+1) )== nums.get(i)){
                    ans[k]=x;
                    flag=true;
                    break;
                }
            }
            if(!flag){
                ans[k]=-1;
            }
           
            k++;
        }
        return ans;
    }
}