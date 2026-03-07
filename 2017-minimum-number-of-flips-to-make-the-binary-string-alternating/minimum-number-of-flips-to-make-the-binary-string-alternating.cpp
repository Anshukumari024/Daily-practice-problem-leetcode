class Solution {
public:
    int minFlips(string s) {
        int n = s.length();
        int ans = INT_MAX;
        int c1 = 0;
        int c2 = 0;
        int i = 0, j = 0;
        while (j < 2 * n) {
            char exp1 = (j % 2 == 1) ? '1' : '0';
            char exp2 = (j % 2 == 1) ? '0' : '1';
            if (s[j % n] != exp1)
                c1++;
            if (s[j % n] != exp2)
                c2++;
            if (j - i + 1 > n) {
                exp1 = (i % 2 == 1) ? '1' : '0';
                exp2 = (i % 2 == 1) ? '0' : '1';

                if (s[i % n] != exp1)
                    c1--;
                if (s[i % n] != exp2)
                    c2--;

                i++;
            }
            if (j - i + 1 == n)
                ans = min(ans, min(c1, c2));

            j++;
        }
        return ans;
    }
};