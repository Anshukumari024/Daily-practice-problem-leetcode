class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> cst=new Stack<>();
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!cst.isEmpty() && cst.peek()==s.charAt(i)) st.push(st.peek()+1);
            else st.push(1);
            cst.push(s.charAt(i));
            if(st.peek()==k){
                for(int j=0;j<k;j++){
                    st.pop();
                    cst.pop();
                }
            }
        }
        StringBuilder str=new StringBuilder();
        while(!cst.isEmpty()){
            str.append(cst.pop());
        }
        return str.reverse().toString();
        
    }
}