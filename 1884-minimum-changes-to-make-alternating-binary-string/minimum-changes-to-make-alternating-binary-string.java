class Solution {
    public int minOperations(String s) {
        int zs=0;
        int os=0;
        int p=0;
        for(int i=0;i<s.length();i++){
            if((s.charAt(i) -'0')!=p) zs++;
            p=1-p;
        }
        int q=1;
        for(int i=0;i<s.length();i++){
            if((s.charAt(i) -'0')!=q) os++;
            q=1-q;
        }
        return Math.min(zs,os);
        
    }
}