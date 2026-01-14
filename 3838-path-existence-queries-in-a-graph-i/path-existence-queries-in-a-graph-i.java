class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] arr=new int[n];
        int g=0;
        arr[0]=0;
        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1]>maxDiff){
                g++;
            }
            arr[i]=g;
        }
        int k=0;
        boolean[] ans=new boolean[queries.length];
        for(int[] q:queries){
            int q1=q[0];
            int q2=q[1];
            if(arr[q1]==arr[q2]){
                ans[k]=true;
            }
            else{
                ans[k]=false;
            }
            k++;

        }
        return ans;
        
    }
}