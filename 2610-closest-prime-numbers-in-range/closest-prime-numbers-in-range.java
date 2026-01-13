class Solution {
    public int[] closestPrimes(int left, int right) {
        List<Integer> list=new ArrayList<>();
        
        for(int i=left;i<=right;i++){
            if(prime(i)){
                list.add(i);
            }
        }
        if(list.size()<=1) return new int[] {-1,-1};
        int[] arr=new int[list.size()];
        for(int i=0;i<arr.length;i++){
            arr[i]=list.get(i);
        }
        int diff=Integer.MAX_VALUE;
        int d=0;
        int[] a=new int[2];
        for(int i=0;i<arr.length-1;i++){
            d=arr[i+1]-arr[i];
            if(d<diff){
                diff=d;
                a[0]=arr[i];
                a[1]=arr[i+1];
            }
            diff=Math.min(diff,d);
        }
        return a;
        
    }
    public static boolean prime(int n){
        if(n<=1) return false;
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}