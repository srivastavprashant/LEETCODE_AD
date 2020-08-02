// # 701: Insert into a Binary Search Tree
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
    
    static void call(TreeNode root, int val)
    {
        if(root!=null)
        {
            if(root.val< val)
            {
                if(root.right== null)
                    root.right= new TreeNode(val);
                else
                    call(root.right, val);
            }
            else
            {
                if(root.left==null)
                    root.left= new TreeNode(val);
                else
                    call(root.left, val);
            }
        }
    }
    
    public TreeNode insertIntoBST(TreeNode root, int val) 
    {
        if(root==null)
            return new TreeNode(val);
        call(root, val);
        return root;
    }
}
