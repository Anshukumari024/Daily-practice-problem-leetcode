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
    int c=0;
    public int minCameraCover(TreeNode root) {
        int co=minCamera(root);
        if(co==-1) c++;
        return c;
    }
     public int minCamera(TreeNode root){
        if(root==null) return 0;
        int left=minCamera(root.left);
        int right=minCamera(root.right);
        if(left==-1 || right==-1){//need camera
            c++;
            return 1;//camera setup
        }
        else if(left==1 || right==1){
            return 0;
        }
        else{
            return -1;
        }
        
     }
}