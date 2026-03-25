class Solution {
    public long minOperations(int[] nums1, int[] nums2) {
        long cost=0;
        for(int i=0;i<nums1.length;i++){
            cost+=Math.abs(nums1[i]-nums2[i]);
        }
        int t=nums2[nums1.length];
        long ec=Long.MAX_VALUE;
        for(int i=0;i<nums1.length;i++){
            int a=nums1[i];
            int b=nums2[i];
            if(t>=Math.min(a,b) && t<=Math.max(a,b)){
                ec=0;
            }
            else{
                ec=Math.min(ec,Math.abs(a-t));
                ec=Math.min(ec,Math.abs(b-t));
            }
        }
        return cost+ec+1;
    }
}