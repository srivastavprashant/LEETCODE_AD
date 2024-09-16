package LeetCodeJ;// 617. Merge Two Binary Trees

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
    static void call(TreeNode root1, TreeNode root2, TreeNode ans)
    {
        if(root1== null && root2== null)
            return;
        
        ans.val= (root1!=null?root1.val: 0)+ (root2!=null?root2.val: 0);
        if((root1!=null && root1.left!=null) || (root2!=null && root2.left!=null))
        {
            TreeNode left= new TreeNode();
            ans.left= left;
            call((root1!=null?root1.left: null), (root2!=null?root2.left: null), left);
        }
        
        if((root1!=null && root1.right!=null) || (root2!=null && root2.right!=null))
        {
            TreeNode right= new TreeNode();
            ans.right= right;
            call((root1!=null?root1.right: null), (root2!=null?root2.right: null), right);
        }
            
    }
    
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2)
    {
        if(root1== null && root2==null)
            return root1;
        TreeNode ans= new TreeNode();
        call(root1, root2, ans);
        
        return ans;
    }
}
