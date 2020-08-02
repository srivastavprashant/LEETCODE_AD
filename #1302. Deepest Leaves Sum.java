// #1302. Deepest Leaves Sum
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
    public int deepestLeavesSum(TreeNode root) 
    {
        int ans=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            int size= q.size();
            ans=0;
            
            for(int i=0;i<size;i++)
            {
                TreeNode temp= q.poll();
                ans+= temp.val;
                
                if(temp.left!=null)
                    q.add(temp.left);
                
                if(temp.right!=null)
                    q.add(temp.right);
            }
        }
        return ans;
    }
}
