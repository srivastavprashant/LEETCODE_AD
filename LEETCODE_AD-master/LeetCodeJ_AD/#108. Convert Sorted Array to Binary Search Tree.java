package LeetCodeJ;// 108. Convert Sorted Array to Binary Search Tree

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
    static void call(int[] nums, int start, int last, TreeNode root)
    {
        if(start<=last)
        {
            int mid= start+ (last- start)/2;
            root.val= nums[mid];
            
            if(last!= mid)
            {
                TreeNode right= new TreeNode();
                root.right= right;
                call(nums, mid+1, last, right);
            }
            
            if(start!= mid)
            {
                TreeNode left= new TreeNode();
                root.left= left;
                call(nums, start, mid-1, left);
            }
        }
    }
    
    public TreeNode sortedArrayToBST(int[] nums) 
    {
        if(nums.length==0)
            return null;
        
        TreeNode root= new TreeNode();
        call(nums, 0, nums.length-1, root);
        return root;
    }
}
