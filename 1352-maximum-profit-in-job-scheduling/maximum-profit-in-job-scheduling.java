class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n=startTime.length;
        int[][] arr=new int[n][3];
        for(int i=0;i<n;i++){
            arr[i][0]=startTime[i];
            arr[i][1]=endTime[i];
            arr[i][2]=profit[i];
        }
        int[] dp=new int[n];
        Arrays.fill(dp,-1);

        Arrays.sort(arr,(a,b) -> a[0]-b[0]);
        return solve(arr,0,dp);
    }
    public int solve(int[][] arr,int i,int[] dp){
        if(i>=arr.length) return 0;
        if(dp[i] !=-1 ) return dp[i];
        int n_i=get(arr,i+1,arr[i][1]);
        int take=arr[i][2]+solve(arr,n_i,dp);
        int not_take=solve(arr,i+1,dp);
        return dp[i]=Math.max(take,not_take);
    }
    public static int get(int[][] arr,int l,int e){
        int r=arr.length-1;
        int ans=arr.length+1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid][0]>=e){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }

        }
        return ans;
    }
}