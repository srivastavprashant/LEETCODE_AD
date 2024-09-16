package LeetCodeJ;//

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
    public List<Integer> inorderTraversal(TreeNode root1) 
    {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> ans=new ArrayList<>();
        stack.add(root1);
        HashSet<TreeNode> seen=new HashSet<>();
        
        if(root1==null)
            return new ArrayList<>();
        
        while(!stack.isEmpty())
            {
                TreeNode root= stack.peek();
                if(root.left!=null && !seen.contains(root.left))
                {
                    stack.add(root.left);
                    seen.add(root.left);
                }
                else
                {
                    ans.add(root.val);
                    root= stack.pop();
                    if(root.right!=null && !seen.contains(root.right))
                    {
                        stack.add(root.right);
                        seen.add(root.right);
                    }
                }
                //System.out.println(ans);
            }
        return ans;
    }
}
