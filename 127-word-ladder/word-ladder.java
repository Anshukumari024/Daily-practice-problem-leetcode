class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>(wordList);
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        set.remove(beginWord);
        while(!q.isEmpty()){
            Pair curr=q.poll();
            String word=curr.str;
            int st=curr.step;
            if(word.equals(endWord)) return st;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] arr=word.toCharArray();
                    arr[i]=ch;
                    String s=new String(arr);
                    if(set.contains(s)){
                        set.remove(s);
                        q.add(new Pair(s,st+1));
                    }
                }
            }
        }
        return 0;
        
    }

}
class Pair{
    String str;
    int step;
    Pair(String str,int step){
        this.str=str;
        this.step=step;
    }
}