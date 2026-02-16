/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<Integer,Integer> map=new HashMap<>();
    int maxf=0;
    public int[] findFrequentTreeSum(TreeNode root) {
        solve(root);
        List<Integer> ll=new ArrayList<>();
        for(int key:map.keySet()){
            if(map.get(key)==maxf) ll.add(key);
        }
        int[] arr=new int[ll.size()];
        for(int i=0;i<ll.size();i++){
            arr[i]=ll.get(i);
        }
        return arr;
        
    }
    public int solve(TreeNode root){
        if(root==null) return 0;
        int l=solve(root.left);
        int r=solve(root.right);
        int sum=l+r+root.val;
        map.put(sum,map.getOrDefault(sum,0)+1);
        maxf=Math.max(maxf,map.get(sum));
        return sum;

    }
}