// 199. Binary Tree right side view

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
    public List<Integer> rightSideView(TreeNode root) 
    {
        if(root==null) return new ArrayList<Integer>();
        Queue<TreeNode> q= new LinkedList<>();
        List<Integer> ans= new ArrayList<>();
        q.add(root);
        TreeNode curr= null;
        
        while(!q.isEmpty())
        {
            int size= q.size();
            
            for(int i=0;i<size;i++)
            {
                curr= q.poll();
                
                if(curr.left!=null)
                    q.add(curr.left);
                
                if(curr.right!=null)
                    q.add(curr.right);
            }
            ans.add(curr.val);
        }
        return ans;
    }
}
