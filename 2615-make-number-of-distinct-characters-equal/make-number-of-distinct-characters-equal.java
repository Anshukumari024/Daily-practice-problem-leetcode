class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        for (char c : word1.toCharArray()) cnt1[c - 'a']++;
        for (char c : word2.toCharArray()) cnt2[c - 'a']++;

        int d1 = 0, d2 = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] > 0) d1++;
            if (cnt2[i] > 0) d2++;
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (cnt1[i] == 0 || cnt2[j] == 0) continue;

                int nd1 = d1, nd2 = d2;

                if (i != j) {
                    if (cnt1[i] == 1) nd1--;
                    if (cnt1[j] == 0) nd1++;

                    if (cnt2[j] == 1) nd2--;
                    if (cnt2[i] == 0) nd2++;
                }

                if (nd1 == nd2) return true;
            }
        }
        return false;
    }
}
