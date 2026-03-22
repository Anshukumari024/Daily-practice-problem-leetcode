class Solution {
    int[] parent;
    public boolean equationsPossible(String[] equations) {
        parent=new int[26];
        for(int i=0;i<26;i++){
            parent[i]=i;
        }
        for(String str:equations){
            if(str.charAt(1)=='='){
                int a=str.charAt(0)-'a';
                int b=str.charAt(3)-'a';
                union(a,b);
            }
        }
        for(String str:equations){
            if(str.charAt(1)=='!'){
                int a=str.charAt(0)-'a';
                int b=str.charAt(3)-'a';
                if(find(a)==find(b)){
                    return false;
                }
            }
        }
        return true;
    }
    public int find(int x){
        if(parent[x]!=x) {
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    public void union(int x,int y){
        int px=find(x);
        int py=find(y);
        if(px!=py)
        parent[px]=py;
    }
}