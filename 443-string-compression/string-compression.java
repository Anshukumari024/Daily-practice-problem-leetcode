class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
        int c=0;
        int idx=0;
        for(int i=0;i<chars.length;i++){
            c=0;
            char ch=chars[i];
            while(i<n && chars[i]==ch){
                c++;
                i++;
            }
            if(c==1){
                chars[idx]=ch;
                idx++;
            }
            else{
                chars[idx]=ch;
                idx++;
                for(char digit:Integer.toString(c).toCharArray()){
                    chars[idx]=digit;
                    idx++;
                }
            }
            i--;
        }
        
        return idx;
    }
}