class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ice=0;
        int i=0;
        while(coins>0 && i<costs.length){
            if(costs[i]<=coins){
                ice++;
                coins-=costs[i];
            }
            else break;
            i++;
        }
        return ice;
        
    }
}