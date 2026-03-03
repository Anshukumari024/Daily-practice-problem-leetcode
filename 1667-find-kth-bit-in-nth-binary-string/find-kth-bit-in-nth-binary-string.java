class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb=new StringBuilder();
        StringBuilder pre=new StringBuilder();
        sb.append(0);
        pre.append(0);
        for(int i=2;i<=n;i++){
            sb.append(1);
            StringBuilder sb1=invert(pre);
            sb1.reverse();
            sb.append(sb1);
            pre=new StringBuilder(sb);

        }
        sb.toString();
        for(int i=0;i<sb.length();i++){
            if(i+1 == k) return sb.charAt(i);
        }
        return '0';
        
    }
    public static StringBuilder invert(StringBuilder s){
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1') str.append(0);
            else str.append(1);
        }
        return str;
    }
}