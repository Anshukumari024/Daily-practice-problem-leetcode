class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        boolean flag=false;
        for(int i=0;i<asteroids.length;i++){
            flag=false;
            while(!st.isEmpty() && asteroids[i]<0  && st.peek()>0){
                if(st.peek()<Math.abs(asteroids[i])){
                    st.pop();
                }
                else if(st.peek()==Math.abs(asteroids[i])){
                    st.pop();
                    flag=true;
                    break;
                }
                else{
                    flag=true;
                    break;
                }
            }
            if(!flag)
            st.push(asteroids[i]);
            
        }
        int idx=st.size()-1;
        int[] ans=new int[st.size()];
        while(!st.isEmpty() && idx>=0){
            ans[idx--]=st.pop();
        }
        return ans;

    }
}