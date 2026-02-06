class Solution {
    int mod=1000000007;
    public int monkeyMove(int n) {
        long r=power(2,n);
        long ans=(r-2+mod)%mod;
        return (int)ans;
        
    }
    public long power(int base,int exp){
        if(exp==0) return 1;
        long r1=power(base,exp/2);
        long r=(r1*r1)%mod;
        if(exp%2 == 1){
            r=(r*base)%mod;
        }
        return r;
    }
}