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
    TreeSet<Integer> set=new TreeSet<>();
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> list=new ArrayList<>();
        inorder(root);
        for(int q: queries){
            Integer l=set.floor(q);
            Integer r=set.ceiling(q);
            if(l==null) l=-1;
            if(r==null) r=-1;
            list.add(Arrays.asList(l,r));
        }
        return list;
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        set.add(root.val);
        inorder(root.right);
    }
}