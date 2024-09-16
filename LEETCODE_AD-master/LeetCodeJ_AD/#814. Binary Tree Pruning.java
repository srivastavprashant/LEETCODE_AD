package LeetCodeJ;// #814. Binary Tree Pruning
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
class Solution 
{
    static void call(TreeNode root)
    {
        if(root!=null)
        {
            if(root.left!=null && root.left.left==null && root.left.right==null && root.left.val==0)
                root.left= null;
            
            if(root.right!=null && root.right.left==null && root.right.right==null && root.right.val==0)
                root.right= null;
            
            call(root.left);
            call(root.right);
            
            if(root.left!=null && root.left.left==null && root.left.right==null && root.left.val==0)
                root.left= null;
            
            if(root.right!=null && root.right.left==null && root.right.right==null && root.right.val==0)
                root.right= null;
        }
    }
    public TreeNode pruneTree(TreeNode root) {
        
        if(root==null)
            return  null;
        
        if(root.left==null && root.right==null && root.val==0)
            return null;
        
        call(root);
        
        return root;
    }
}
