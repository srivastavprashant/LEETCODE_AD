// #1305. All Elements in Two Binary Search Trees
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
    static List<Integer> ans;
    
    static void call(TreeNode root)
    {
        if(root!=null)
        {
            call(root.left);
            ans.add(root.val);
            call(root.right);
        }
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) 
    {
        ans=new ArrayList<>();
        call(root1);
        call(root2);
        Collections.sort(ans);
        
        return ans;
    }
}
