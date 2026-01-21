class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int xo1=0;
        int xo2=0;
        for(int num:arr1){
            xo1^=num;
        }
         for(int num:arr2){
            xo2^=num;
        }
        return xo1&xo2;
    }
}