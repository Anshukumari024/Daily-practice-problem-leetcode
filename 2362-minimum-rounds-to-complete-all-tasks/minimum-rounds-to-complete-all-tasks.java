class Solution {
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int e:tasks){
            map.put(e,map.getOrDefault(e,0)+1);
        }
        for(int e:map.keySet()){
            if(map.get(e)<2) return -1;
        }
        int t=0;
        for(int e:map.keySet()){
            int t1=Integer.MAX_VALUE;
            int t2=Integer.MAX_VALUE;
            int t3=Integer.MAX_VALUE;
            int w=map.get(e);
            if(w==2) t++;
            else if(w==3) t++;
            else{
                if(w%3==0) t1=(w/3);
                if(w%2==0) t2=(w/2);
                
                
                    t3=(w/3)+1;
                    
                
                 t+=Math.min(t1,Math.min(t2,t3));
            }
           
        }
        return t;
    }
}