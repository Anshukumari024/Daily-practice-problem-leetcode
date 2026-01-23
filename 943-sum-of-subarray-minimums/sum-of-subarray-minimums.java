class Solution {
    int mod = 1000000007;
    public int sumSubarrayMins(int[] arr) {
        int[] l=pse(arr);
        int[] r=nse(arr);
        long ans=0;
        for(int i=0;i<arr.length;i++){
            int left=i-l[i];
            int right=r[i]-i;
            ans = (ans + (long) arr[i] * left * right) % mod;

        }
        return (int)(ans%mod);
        
    }
    public int[] pse(int[] arr){
        Stack<Integer> st =new Stack<>();
        int[] ans=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=-1;
            }
            else{
                ans[i]=st.peek();
            }
            st.push(i);
        }
        return ans;
    }
    public static int[] nse(int[] arr){
        int[] ans=new int[arr.length];
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=n;
            }
            else ans[i]=st.peek();
            st.push(i);
        }
        return ans;
    }

}