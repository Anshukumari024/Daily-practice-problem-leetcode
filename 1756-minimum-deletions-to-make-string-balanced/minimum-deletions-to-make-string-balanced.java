class Solution {
    public int minimumDeletions(String s) {
        Stack<Integer> st=new Stack<>();
        int c=0;
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty() && s.charAt(i)=='a' && s.charAt(st.peek())=='b'){
                c++;
                st.pop();
            }
            else{
                st.push(i);
            }
        }
        return c;
    }
}