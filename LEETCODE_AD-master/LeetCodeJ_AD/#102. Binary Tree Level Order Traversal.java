package LeetCodeJ;// 102. Binary Tree Level Order Traversal

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
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root!=null)
            q.add(root);
        
        while(!q.isEmpty())
        {
            int size= q.size();
            List<Integer> temp=new ArrayList<>();
            
            for(int i=0;i<size;i++)
            {
                TreeNode curr= q.poll();
                temp.add(curr.val);
                
                if(curr.left!=null)
                    q.add(curr.left);
                
                if(curr.right!=null)
                    q.add(curr.right);
            }
            ans.add(temp);
        }
        return ans;        
    }
}
