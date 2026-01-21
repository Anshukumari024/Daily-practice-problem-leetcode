class Solution {
    public int largestVariance(String s) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        int res = 0;
        for(char i = 'a'; i <= 'z'; i++){
            for(char j = 'a'; j<='z'; j++){
                if(freq[i-'a'] == 0 || freq[j-'a'] == 0){
                    continue;
                }
                int first = 0;
                int second = 0;
                boolean past = false;
                for(char ch : s.toCharArray()){
                    if(ch == i){
                        first++;
                    }
                    if(ch == j){
                        second++;
                    }
                    if(second > 0){
                        res = Math.max(res,first-second);
                    }
                    else {
                        if(past){
                            res = Math.max(res,first-1);
                        }
                    }
                    if(second > first){
                        second = 0;
                        first = 0;
                        past = true;
                    }
                }
            }
        }
        return res;
    }
}