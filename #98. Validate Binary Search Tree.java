// #98. Validate Binary Search Tree



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
    boolean call(TreeNode root, long min, long max)
    {
        if(root== null)
            return true;
        else
        {
            int val= root.val;
            if(val>=max || val<= min) return false;
            if(root.left!= null && val<=root.left.val) return false;
            if(root.right!= null && val>=root.right.val) return false;
                
            return call(root.left, min, val)&& call(root.right, val, max);   
        }
    }
    
    public boolean isValidBST(TreeNode root) 
    {
        return call(root, Integer.MIN_VALUE-2l, Integer.MAX_VALUE+2l);
    }
}
