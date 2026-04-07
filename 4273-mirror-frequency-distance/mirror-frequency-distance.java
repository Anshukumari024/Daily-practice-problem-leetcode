class Solution {
    public int mirrorFrequency(String s) {
        int ans = 0;

        int[] f1 = new int[26];
        int[] f2 = new int[26];
        int[] d1 = new int[10];
        int[] d2 = new int[10];

        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch))
                f1[ch - 'a']++;
            else
                d1[ch - '0']++;
        }

        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                char nch = (char) ('a' + 'z' - ch);
                f2[nch - 'a']++;
            } else {
                char nch = (char) ('0' + '9' - ch);
                d2[nch - '0']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            ans += Math.abs(f1[i] - f2[i]);
        }

        for (int i = 0; i < 10; i++) {
            ans += Math.abs(d1[i] - d2[i]);
        }

        return ans / 2; 
    }
}