// #1315. Sum of Nodes with Even-Valued Grandparent

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
    
    static int ans=0;
    
    static void call(TreeNode root, boolean parent, boolean grandparent)
    {
        if(root!=null)
        {
            if(grandparent)
                ans+= root.val;
            grandparent= parent;
            
            if((root.val&1)==0)
                parent= true;
            else
                parent= false;
            
            call(root.left, parent, grandparent);
            call(root.right, parent, grandparent);                
        }
    }
    
    public int sumEvenGrandparent(TreeNode root) 
    {
        ans=0;
        call(root, false, false);
        return ans;
    }
}
