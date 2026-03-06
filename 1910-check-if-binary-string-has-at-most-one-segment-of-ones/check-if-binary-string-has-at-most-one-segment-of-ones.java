class Solution {
    public boolean checkOnesSegment(String s) {
       int fi=-1;
       int li=-1;
       int c=0;
       for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') c++;
            if((fi ==-1) && s.charAt(i)=='1') {
                fi=i;
                continue;
            }
            else if(s.charAt(i)=='1') li=i;
       }  
       if(c<=1) return true;
       if(li-fi+1 == c) return true;
       return false;

    }
    
}