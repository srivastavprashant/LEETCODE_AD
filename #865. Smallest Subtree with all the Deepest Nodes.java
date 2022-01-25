
# 865. Smallest Subtree with all the Deepest Nodes


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
    static int max;
    static TreeNode ans;
    static int call(TreeNode root, int height)
    {
        if(root== null)
            return 0;
        
        int left= call(root.left, height+1);
        int right= call(root.right, height+1);
        
        if(left== right && max<= height+ left)
        {
            ans= root;
            max= height+ left;
        }
        
        return Math.max(left, right)+1;
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) 
    {
        ans= root;
        max= 0;
        call(root, 0);
        return ans;
    }
}
