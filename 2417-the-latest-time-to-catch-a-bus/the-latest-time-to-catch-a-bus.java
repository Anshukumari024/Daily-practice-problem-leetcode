class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        HashSet<Integer> set=new HashSet<>();
        int c=0;
        int ans=0;
        int j=0;
        for(int i=0;i<buses.length;i++){
            c=0;
            while(j<passengers.length && c<capacity && passengers[j]<=buses[i]){
                if(!set.contains(passengers[j]-1)){
                    ans=passengers[j]-1;
                }
                set.add(passengers[j]);
                j++;
                c++;
            }
            if(c<capacity && !set.contains(buses[i])){
                ans=buses[i];
            }
        }
        return ans;
        
    }
}