class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=Integer.MIN_VALUE;
        for(int a:arr){
            int pre=a-difference;
            int curr=map.getOrDefault(pre,0)+1;
            map.put(a,curr); 
            ans=Math.max(ans,curr);
        }
        return ans;
    }
}