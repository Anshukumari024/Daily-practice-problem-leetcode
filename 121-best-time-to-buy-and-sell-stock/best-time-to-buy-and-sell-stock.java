class Solution {
    public int maxProfit(int[] prices) {
        int p=0;
        int m=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            m=Math.min(prices[i],m);
            p=Math.max(p,prices[i]-m);
        }
        return p;
        
    }
}