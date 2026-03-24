class Solution {
    public int bestClosingTime(String customers) {
        int n=customers.length();
        int[] Y=new int[n+1];
        int[] N=new int[n+1];
        Y[n]=0;
        for(int i=n-1;i>=0;i--){
            Y[i]=Y[i+1];
            if(customers.charAt(i)=='Y'){
                Y[i]++;
            }
        }
        N[0]=0;
        for(int i=1;i<=n;i++){
            N[i] = N[i - 1];
            if (customers.charAt(i - 1) == 'N') {
                N[i]++;
            }
        }
        int[] ans= new int[n+1];
        int result=Integer.MAX_VALUE;
        int idx=0;
        for(int i=0;i<=n;i++){
            ans[i]=N[i]+Y[i];
            if(ans[i]<result){
                idx=i;
                result=ans[i];

            }
        }
        return idx;
        
    }
}