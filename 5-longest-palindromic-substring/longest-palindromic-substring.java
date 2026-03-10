class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<=1) return s;
        String str="";
        String fstr=s.substring(0,1);
        int l=1;
        for(int i=0;i<s.length();i++){
            for(int j=i+l;j<=s.length();j++){
                str=s.substring(i,j);
                if(j-i>l && palindrome(str)){
                    l=j-i;
                    fstr=str;
                }
            }
        }
        return fstr;
        
    }
    public static boolean palindrome(String s1){
        int i=0;
        int j=s1.length()-1;
        while(i<j){
            if(s1.charAt(i)!=s1.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}