class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int maxh=1;
        int maxv=1;
        int cs=1;
        for(int i=1;i<hBars.length;i++){
            if(hBars[i]-hBars[i-1]==1){
                cs++;
            }
            else{
                cs=1;
            }
            maxh=Math.max(maxh,cs);
        }
        cs=1;
        for(int i=1;i<vBars.length;i++){
            if(vBars[i]-vBars[i-1]==1){
                cs++;
            }
            else{
                cs=1;
            }
            maxv=Math.max(maxv,cs);
        }

        int s=Math.min(maxh+1,maxv+1);
        return s*s;
    }
}