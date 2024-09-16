package LeetCodeJ;// #1448. Count Good Nodes in Binary Tree

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
    static int ans=0, max=0;
    
    static void call(TreeNode root)
    {
        if(root!=null)
        {
            if(max<=root.val) {ans++; max= root.val;}
            root.val= max;
            
            call(root.left);
            max= root.val;
            call(root.right);
            
            max= root.val;
        }
    }
    
    public int goodNodes(TreeNode root) 
    {
        ans=0;
        max= Integer.MIN_VALUE;
        call(root);
        
        return ans;
    }
}
