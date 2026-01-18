class Solution {
    public long maxTotal(int[] value, int[] limit) {
        HashMap<Integer,ArrayList<Integer> > map=new HashMap<>();
        for(int i=0;i<value.length;i++){
            if(!map.containsKey(limit[i])){
                map.put(limit[i],new ArrayList<>());
            }
            map.get(limit[i]).add(value[i]);
        }
        long ans=0;
        for(int l:map.keySet()){
            ArrayList<Integer> ll=map.get(l);
            Collections.sort(ll,Collections.reverseOrder());
            for(int i=0;i<Math.min(l,ll.size());i++){
                ans+=ll.get(i);
            }
        }
        return ans;
    }
}
