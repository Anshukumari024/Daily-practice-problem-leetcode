class Solution {
    String ans="";
    int k;
    public String getHappyString(int n, int k) {
        this.k=k;
        solve(n,"");
        return ans;
    }
    public void solve(int n,String curr){
        if(curr.length()==n){
            k--;
            if(k==0) ans= curr;
            return;
        }
        for(char ch='a';ch<='c';ch++){
            if(curr.length()>0 && curr.charAt(curr.length()-1)==ch) continue;
           solve(n,curr+ch);
            if(k == 0) return;
        }
    }
}