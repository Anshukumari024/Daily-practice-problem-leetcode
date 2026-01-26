class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int mi=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            mi=Math.min(mi,arr[i]-arr[i-1]);
        }
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        boolean flag=false;
        for(int i=1;i<arr.length;i++){
            flag = false;
            if((arr[i]-arr[i-1])==mi){
                flag=true;
                ll.add(arr[i-1]);
                ll.add(arr[i]);
            }
            if(flag)
            list.add(new ArrayList<>(ll));
            ll.clear();
        }
        return list;
        
    }
}