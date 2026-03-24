class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(char ch:tasks){
            freq[ch-'A']++;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<26;i++){
            if(freq[i]>0) pq.add(freq[i]);
        }
        int ans=0;
        while(!pq.isEmpty()){
            int task=0;
            int cycle = n+1;
            ArrayList<Integer> ll=new ArrayList<>();
            while(!pq.isEmpty() && cycle-->0){
                int curr=pq.poll();
                if(curr>1){
                    ll.add(curr-1);
                }
                task++;
            }
            for(int e:ll){
                    pq.add(e);
                }
            if(pq.isEmpty()){
                ans+=task;
            }
            else{
                ans+=(n+1);
            }
        }
        return ans;
    }
}