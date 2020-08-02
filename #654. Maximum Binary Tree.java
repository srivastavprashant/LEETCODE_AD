// #654. Maximum Binary Tree

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
    
    static void call(int[] nums,int start, int last, TreeNode root)
    {
        if(start<=last)
        {
            int mid= max(nums, start, last);
            root.val= nums[mid];
            
            if(start<=mid-1)
            {
                TreeNode left= new TreeNode();
                root.left= left;
                call(nums, start, mid-1, left);
            }
            
            if(mid+1<=last)
            {
                TreeNode right= new TreeNode();
                root.right= right;
                call(nums, mid+1, last, right);
            }
        }
    }
    
    static int max(int[] nums, int start, int last)
    {
        int index=-1, max=Integer.MIN_VALUE;
        for(int i=start;i<=last;i++)
            if(max<nums[i])
            {
                max= nums[i];
                index= i;
            }
        return index;
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums) 
    {
        TreeNode root=new TreeNode();
        call(nums, 0, nums.length-1, root);
        return root;       
    }
}
