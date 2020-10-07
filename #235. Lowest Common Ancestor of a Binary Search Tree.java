// 235. Lowest Common Ancestor of a Binary Search Tree


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution 
{
    static TreeNode ans;
    static int call(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root== null)
            return 0;
        else
        {
            int left= call(root.left, p, q);
            int right= call(root.right, p, q);
            
            if(left+right+(root.val== p.val|| root.val== q.val? 1:0)== 2 && ans==null)
                ans= root;
            
            return ((p.val== root.val || q.val== root.val)?1 :0)+ left+ right;
        }
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        ans= null;
        call(root, p, q);
        
        return ans;
    }
}
