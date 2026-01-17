class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        if (k==1) return nums;
        int[] ans=new int[n-k+1];
        int c= 0; 
        for (int i=1;i<n;i++) {
            if (nums[i]-nums[i-1]==1) c++;
            else c=0;
            if (i>= k-1) {
                if (c>= k-1) ans[i-k+1]=nums[i]; 
                else  ans[i-k+1]=-1;
            }
        }
        return ans;
    }
}
