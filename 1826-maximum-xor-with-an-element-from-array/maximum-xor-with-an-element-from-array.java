class Solution {
    public int[] maximizeXor(int[] arr, int[][] queries) {
        int[][] q=new int[queries.length][3];
        for(int i=0;i<q.length;i++){
            q[i][0]=queries[i][0];
            q[i][1]=queries[i][1];
            q[i][2]=i;
        }
        Arrays.sort(q,(a,b) -> (a[1]-b[1]));
        Arrays.sort(arr);
        int[] ans=new int[q.length];
        Trie t=new Trie();
        int j=0;
        for(int[] a:q){
            while(j<arr.length && arr[j] <=a[1]){
                t.add(arr[j]);
                j++;
            }
            if(j==0){
                ans[a[2]]=-1;
            }
            else{
                ans[a[2]]=t.getMaxXor(a[0]);
            }
        }
        return ans;


    }
    static class Trie{
		class Node{
			Node zero;
			Node one;
			
		}
		private Node root = new Node();
		
		
		public void add(int val) {
			Node curr = root;
			for(int i=31; i>=0; i--) {
				int a= (1<<i)&val;
				if(a==0) {
					if(curr.zero==null) {
						curr.zero = new Node();
					}
					curr = curr.zero;
					
				}
				else {
					if(curr.one==null) {
						curr.one = new Node();
					}
					curr = curr.one;
				}
			}
		}
		
		public int getMaxXor(int x) {
			int ans = 0;
			Node curr = root;
			for(int i=31; i>=0; i--) {
				int a= (1<<i)&x;
				if(a==0) {
					if(curr.one!=null) {
						ans|=(1<<i);
						curr = curr.one;
					}
					else {
						curr = curr.zero;
					}	
				}
				else {
					if(curr.zero!=null) {
						ans|=(1<<i);
						curr = curr.zero;
					}
					else {
						curr = curr.one;
					}
					
				}
			}
			return ans;
		}
	}
}
