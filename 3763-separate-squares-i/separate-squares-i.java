class Solution {
    public double separateSquares(int[][] squares) {
        double total_area=0;
        double l = Double.MAX_VALUE;
        double r = Double.MIN_VALUE;

        for(int[] s:squares){
             l=Math.min(l,s[1]);
             r=Math.max(r,s[1]+s[2]);
            total_area+=(double)s[2]*s[2];

        }
        double ans=0.0;
        while(r - l > 1e-6){
            double mid=l+(r-l)/2.0;
            if(area(squares,mid)>=total_area/2.0){
                r =mid;
            }
            else l=mid;
        }
        return r;

    }
    public double area(int[][] squares,double mid){
        double a=0.0;
        for(int[] s: squares){
            if(mid<=s[1]) continue;
            else if(mid>=s[1]+s[2]){
                a+=(double)s[2]*s[2];
            }
            else a+=(double)(s[2]*(mid-s[1]));
        }
        return a;
    }
}