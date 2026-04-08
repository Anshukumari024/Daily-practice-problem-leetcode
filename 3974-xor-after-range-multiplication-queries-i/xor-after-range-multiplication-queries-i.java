class Solution {
    static int mod=1000000007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int xor=0;
        for(int[] q:queries){
            int l=q[0];
            int r=q[1];
            int k=q[2];
            int v=q[3];
            for(int i=l;i<=r;i+=k){
                nums[i]=(int)((1L*nums[i]*v)%mod);
            }
        }
        for(int i=0;i<nums.length;i++){
            xor=(xor^nums[i]);
        }
        return xor;
    }
}