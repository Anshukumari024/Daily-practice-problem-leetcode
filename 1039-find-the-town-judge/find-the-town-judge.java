class Solution {
    public int findJudge(int n, int[][] trust) {
       int[] arr=new int[n];
       for(int[] t:trust){
        arr[t[0]-1]--;
        arr[t[1]-1]++;
       }
      for(int i=0;i<arr.length;i++){
        if(arr[i]==n-1) return i+1;
      }
      return -1;
      
    }
}