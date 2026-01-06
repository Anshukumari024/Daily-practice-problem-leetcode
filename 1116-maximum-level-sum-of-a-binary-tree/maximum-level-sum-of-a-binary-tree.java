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
    public int maxLevelSum(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,1));
        int maxsum=root.val;
        int m_l=1;
        while(!q.isEmpty()){
            int size=q.size();
           int c_l=q.peek().level;
            int s=0;
            while(size-->0){
                 Pair rv=q.poll();
                if(rv.node.left!=null){
                    q.add(new Pair(rv.node.left,c_l+1));
                    
                }
                 if(rv.node.right!=null){
                    q.add(new Pair(rv.node.right,c_l+1));
            
                }
                s+=rv.node.val;
            }
            if(s>maxsum){
                maxsum=s;
                m_l=c_l;
            }
        }
        return m_l;
    }
    class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node,int level){
            this.node=node;
            this.level=level;
        }
    }
}