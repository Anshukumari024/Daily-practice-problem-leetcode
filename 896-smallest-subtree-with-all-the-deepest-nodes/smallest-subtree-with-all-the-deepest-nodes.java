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
    int maxd=0;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        HashMap<Integer,Integer> map=new HashMap<>();
        depth(root,0,map);
        
        return lca(root,map);
    }
    public void depth(TreeNode root,int d,HashMap<Integer,Integer> map){
        if(root==null) return;
        maxd=Math.max(maxd,d);
        map.put(root.val,d);
        depth(root.left,d+1,map);
        depth(root.right,d+1,map);
    }
    public TreeNode lca(TreeNode root, HashMap<Integer,Integer> map){
        if(root==null || map.get(root.val)==maxd) return root;
        TreeNode left=lca(root.left,map);
        TreeNode right=lca(root.right,map);
        if(left!=null && right!=null){
            return root;
        }
        else if(left==null){
            return right;
        }
        else{
            return left;
        }


    }
}