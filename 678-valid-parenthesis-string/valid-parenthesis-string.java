class Solution {
    Boolean[][] dp;
    public boolean checkValidString(String s) { 
         dp=new Boolean[s.length()+1][s.length()+1];
        return solve(s,0,0);
    }
    public boolean solve(String s,int o,int i){
        if(o < 0) return false;
        if(i==s.length()){
            if(o==0) return true;
            return false;
        }
        if(dp[o][i]!=null) return dp[o][i];
        boolean flag=false;
        if(s.charAt(i)=='*'){
            flag|=solve(s,o+1,i+1);
            flag|=solve(s,o,i+1);
            if(o>0){
                flag|=solve(s,o-1,i+1);
            }
        }
        else if(s.charAt(i)=='('){
            flag|=solve(s,o+1,i+1);
        }
        else{
            flag|=solve(s,o-1,i+1);
        }
        return dp[o][i]=flag;

    }

}