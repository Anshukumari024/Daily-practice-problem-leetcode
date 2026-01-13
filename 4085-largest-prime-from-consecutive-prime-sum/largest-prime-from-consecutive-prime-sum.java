class Solution {
    public int largestPrime(int n) {
        int sum=0;
        int ps=0;
        for(int i=2;sum<=n ;i++){
            if(Prime(i)){
                sum+=i;
                if(sum<=n && (Prime(sum))) ps=sum;
            }
        }
        return ps;
        
    }
    public boolean Prime(int p) {
        if (p <= 1) return false;
        for (int i = 2; i * i <= p; i++) {
            if (p % i == 0) return false;
        }
        return true;
    }
}