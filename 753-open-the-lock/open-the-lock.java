class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> set=new HashSet<>(Arrays.asList(deadends));
        if(set.contains("0000")) return -1;
        HashSet<String> vis=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        q.add("0000");
        vis.add("0000");
        int steps=0;
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                String curr=q.poll();
                if(curr.equals(target)) return steps;
                for(String neig:getNeig(curr)){
                    if(!(set.contains(neig)) && !(vis.contains(neig))){
                        q.add(neig);
                        vis.add(neig);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    public List<String> getNeig(String s){
        List<String> ll=new ArrayList<>();
        for(int i=0;i<4;i++){
            char[] arr=s.toCharArray();
            char ch=arr[i];
            arr[i]=(char)(((ch-'0')+1)%10 + '0');
            ll.add(new String(arr));
            arr[i]=(char)(((ch-'0')+9)%10 + '0');
            ll.add(new String(arr));
        }
        return ll;
    } 
}