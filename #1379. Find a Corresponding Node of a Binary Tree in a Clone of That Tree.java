// # 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) 
    {
        Queue<TreeNode> q=new LinkedList<>();
        Queue<TreeNode> q2=new LinkedList<>();
        q.add(original);
        q2.add(cloned);
        
        while(!q.isEmpty())
        {
            TreeNode root_orig= q.poll();
            TreeNode root_clone= q2.poll();
            if(root_orig==target)
                return root_clone;
            
            if(root_orig.left!=null)
            {
                q.add(root_orig.left);
                q2.add(root_clone.left);
            }
            
            if(root_orig.right!=null)
            {
                q.add(root_orig.right);
                q2.add(root_clone.right);
            }
        }
        return original;
    }
}
