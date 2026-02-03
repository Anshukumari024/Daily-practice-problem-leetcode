class Solution {
    public boolean isTrionic(int[] arr) {
        int i=0;
        int n=arr.length;
        if(n<=3) return false;
        while(i+1<n-1 && arr[i]<arr[i+1]){
            i++;
        }
        if(i==0 || i==n-1) return false;
        int c=i;
        while(i+1<n && arr[i]>arr[i+1]){
            i++;
        }
        if(i==n-1 || i==c) return false;
        while(i+1<n && arr[i]<arr[i+1]){
            i++;
        }
        return i==n-1;

    }
}