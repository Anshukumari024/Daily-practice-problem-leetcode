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
    List<Integer> ll=new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return balance(0,ll.size()-1);
        
    }
    public TreeNode balance(int l,int r){
        if(l>r) return null;
        int mid=l+(r-l)/2;
        TreeNode node=new TreeNode(ll.get(mid));
        node.left=balance(l,mid-1);
        node.right=balance(mid+1,r);
        return node;
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        ll.add(root.val);
        inorder(root.right);
    }
}