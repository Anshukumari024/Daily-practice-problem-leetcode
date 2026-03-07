class Solution {
    public int minFlips(String s) {
        int n = s.length();
        s = s + s;

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for(int k = 0; k < 2*n; k++){
            s1.append(k%2==1 ? '0':'1');
            s2.append(k%2==1 ? '1':'0');
        }

        int c1 = 0, c2 = 0;
        int ans = Integer.MAX_VALUE;

        int i = 0, j = 0;

        while(j < 2*n){

            if(s.charAt(j) != s1.charAt(j)) c1++;
            if(s.charAt(j) != s2.charAt(j)) c2++;

            if(j-i+1 > n){
                if(s.charAt(i) != s1.charAt(i)) c1--;
                if(s.charAt(i) != s2.charAt(i)) c2--;
                i++;
            }

            if(j-i+1 == n){
                ans = Math.min(ans, Math.min(c1, c2));
            }

            j++;
        }

        return ans;
    }
}