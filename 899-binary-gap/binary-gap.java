class Solution {
    public int binaryGap(int n) {
        int md= 0;
        int c = 0;
        boolean found = false;
        
        while (n > 0) {
            int bit = n % 2;
            
            if (bit == 1) {
                if (found) {
                   md = Math.max(md, c);
                }
                c = 1;
                found = true;
            } else {
                if (found) {
                    c++;
                }
            }
            
            n /= 2;
        }
        
        return md;
    }
}