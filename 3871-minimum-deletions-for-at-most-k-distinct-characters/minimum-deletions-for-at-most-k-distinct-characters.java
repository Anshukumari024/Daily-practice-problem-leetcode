class Solution {
    public int minDeletion(String s, int k) {
        int[] f=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            f[ch-'a']++;
        }
        List<Integer> ll=new ArrayList<>();
        for(int i=0;i<26;i++){
            if(f[i]>0) ll.add(f[i]);
        }
        Collections.sort(ll);
        int ans=0;
        int r=ll.size()-k;
        for(int i=0;i<r;i++){
            ans+=ll.get(i);
        }
        return ans;
        
    }
}