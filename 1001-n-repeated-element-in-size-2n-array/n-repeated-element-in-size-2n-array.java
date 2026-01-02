class Solution {
    public int repeatedNTimes(int[] nums) {
        int n=nums.length/2;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int e:map.keySet()){
            if(map.get(e)==n) return e;
        }
        return -1;
        
    }
}