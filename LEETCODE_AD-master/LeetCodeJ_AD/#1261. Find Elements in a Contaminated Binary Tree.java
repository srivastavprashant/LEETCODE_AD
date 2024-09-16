package LeetCodeJ;// #1261. Find Elements in a Contaminated Binary Tree
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
class FindElements 
{
    TreeNode root;
    HashSet<Integer> set;
    
    public FindElements(TreeNode root) 
    {
        this.root= root;
        set=new HashSet<Integer>();
        recover(root, 0);
    }
    
    void recover(TreeNode root, int value)
    {
        if(root!=null)
        {
            root.val= value;
            set.add(value);
            recover(root.left, value*2+1);
            recover(root.right, value*2+2);
        }
    }
    
    public boolean find(int target) 
    {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
