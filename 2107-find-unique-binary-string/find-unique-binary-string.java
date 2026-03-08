class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set=new HashSet<>();
        for(String num:nums){
            set.add(num);
        }
        return solve(nums[0].length(),"",set);
    }
    public String solve(int n,String ans,HashSet<String> set){
        if(ans.length()==n){
            if(!set.contains(ans)){
                return ans;
            }
            return "";
        }
        String l=solve(n,ans+"0",set);
        if(!l.equals("")) return l;
        return solve(n,ans+"1",set);
    }
}