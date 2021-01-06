// #998. Maximum Binary Tree II



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
    void call(TreeNode root, int val)
    {
        if(root.right!= null && root.right.val< val)
        {
            TreeNode ret= new TreeNode(val, root.right, null);
            root.right= ret;
            return;
        }
        else if(root.right== null)
        {
            root.right= new TreeNode(val);
            return;
        }
        
        call(root.right, val);
    }
    
    public TreeNode insertIntoMaxTree(TreeNode root, int val) 
    {
        if(root.val< val)
            return new TreeNode(val, root, null);
        
        call(root, val);
        return root;
    }
}
