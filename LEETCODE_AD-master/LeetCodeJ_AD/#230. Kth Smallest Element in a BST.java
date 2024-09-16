package LeetCodeJ;// #230. Kth Smallest Element in a BST


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
    int ret, no_of_nodes_seen;
    void call(TreeNode root, int k)
    {
        if(root== null)
            return ;
        
        call(root.left, k);
        no_of_nodes_seen++;
        if(no_of_nodes_seen== k) ret= root.val;
        call(root.right, k);
    }
    
    public int kthSmallest(TreeNode root, int k) 
    {
        ret= -1;
        no_of_nodes_seen= 0;
        call(root, k);
        
        return ret;
    }
}
