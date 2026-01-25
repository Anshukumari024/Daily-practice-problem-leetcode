class Solution {
    static final int MOD = 1_000_000_007;
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        long ans=0;
        int n=inventory.length;
        for(int i=n-1;i>=0 && orders>0;i--){
            int curr=inventory[i];
            int pre=0;
            if(i>0) pre=inventory[i-1];
            long c=n-i;
            long nos=c*(curr-pre);
            if(orders>=nos){
                ans+=c*sum(curr,pre+1);
                orders-=nos;
            }
            else{
                long fl=orders/c;
                long pl=orders%c;
                ans+=c*sum(curr,curr-fl+1);
                ans+=pl*(curr-fl);
                orders=0;
            }
             ans %= MOD;
        }
        return (int)ans;
        
    }
    public long sum(long high, long low) {
        return (high + low) * (high - low + 1) / 2;
    }
}