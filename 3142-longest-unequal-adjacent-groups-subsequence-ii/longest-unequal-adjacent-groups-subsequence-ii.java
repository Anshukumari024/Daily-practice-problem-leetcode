class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int[] dp=new int[words.length];
        int[] parent=new int[words.length];
        Arrays.fill(dp,1);
        Arrays.fill(parent,-1);
        int ml=1;
        int idx=0;
        for(int i=1;i<words.length;i++){
            for(int j=0;j<i;j++){
                if(groups[i]!=groups[j] && words[i].length()==words[j].length() && h_d(words[i],words[j])){
                    if(dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    parent[i]=j;
                    }
                }
                if(ml<dp[i]){
                    ml=dp[i];
                    idx=i;
                }
            }
        }
        List<String> ll=new ArrayList<>();
        while(idx!=-1){
            ll.add(words[idx]);
            idx=parent[idx];
        }
         Collections.reverse(ll);
         return ll;
    }
    public boolean h_d(String a, String b) {
    int diff = 0;
    for (int i = 0; i < a.length(); i++) {
        if (a.charAt(i) != b.charAt(i)) {
            diff++;
            if (diff > 1) return false;
        }
    }
    return diff == 1;
}

}