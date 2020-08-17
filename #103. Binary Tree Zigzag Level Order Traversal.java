//103. Binary Tree Zigzag Level Order Traversal


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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root!=null)
            q.add(root);
        
        boolean counter= true;
        while(!q.isEmpty())
        {
            int size= q.size();
            ArrayList<Integer> temp=new ArrayList<>();
            
            for(int i=0;i<size;i++)
            {
                TreeNode curr= q.poll();
                temp.add(curr.val);
                
                if(curr.left!=null)
                    q.add(curr.left);
                
                if(curr.right!=null)
                    q.add(curr.right);                
            }
            
            if(!counter)
            Collections.reverse(temp);
        
            ans.add(temp);
            counter= !counter;
        }
        return ans;        
    }
}
