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
    long t_s=0;
    long m_p=0;
    static final int MOD = 1_000_000_007;
    public int maxProduct(TreeNode root) {
        t_s=totalsum(root);
         subsum(root);
         return (int)(m_p%MOD);
        
    }
    public int totalsum(TreeNode root){
        if(root==null) return 0;
        return root.val+totalsum(root.left)+totalsum(root.right);
    }
    public long subsum(TreeNode root){
        if(root==null) return 0;
        long left=subsum(root.left);
        long right=subsum(root.right);
        long s_s=root.val+left+right;
        m_p=Math.max(m_p,(t_s-s_s)*s_s);
        return s_s;
    }
}