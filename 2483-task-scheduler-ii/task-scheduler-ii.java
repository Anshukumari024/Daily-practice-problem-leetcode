class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        HashMap<Integer,Long> map=new HashMap<>();
        long day=1;
        for(int i=0;i<tasks.length;i++){
            if(!map.containsKey(tasks[i])){
                map.put(tasks[i],day);
            }
            else{
                if(day-map.get(tasks[i])-1 < space){
                    long add=day-map.get(tasks[i])-1;
                    day+=(long)(space-add);
                }
                map.put(tasks[i],day);
                
            }
            day++;
        }
        return day-1;
    }
}