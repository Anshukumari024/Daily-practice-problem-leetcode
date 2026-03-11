class Solution {
    public int bitwiseComplement(int n) {
        String binary = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();

        for(char c : binary.toCharArray()) {
            if(c == '0') sb.append('1');
            else sb.append('0');
        }

        return Integer.parseInt(sb.toString(), 2);
    }
}