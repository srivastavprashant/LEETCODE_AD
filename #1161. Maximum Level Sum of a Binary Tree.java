// #1161. Maximum Level Sum of a Binary Tree
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
    public int maxLevelSum(TreeNode root) 
    {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int maxSum=Integer.MIN_VALUE, ans=1, index=1;
        
        while(!q.isEmpty())
        {
            int size= q.size();
            int sum=0;
            
            for(int i=0;i<size;i++)
            {
                TreeNode temp= q.poll();
                sum+= temp.val;
                
                if(temp.left!=null)
                    q.add(temp.left);
                
                if(temp.right!=null)
                    q.add(temp.right);
            }
            
            if(maxSum<sum)
            {
                maxSum= sum;
                ans= index;
            }
            index++;
        }
        return ans;
    }
}
