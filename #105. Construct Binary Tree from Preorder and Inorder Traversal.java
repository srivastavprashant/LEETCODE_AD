/*
  105. Construct Binary Tree from Preorder and Inorder Traversal
*/

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
    static int[] preorder;
    static int[] inorder;
    static HashMap<Integer, Integer> map;
    public static void call(TreeNode i, int start, int last, TreeNode root)
    {
        if(start<=last)
        {
            root.val= preorder[i.val++];
            int mid= map.get(root.val);
            TreeNode left=new TreeNode();
            TreeNode right=new TreeNode();
            if(start<=mid-1)
            {
                root.left= left;
                call(i, start, mid-1, root.left);
            }
            
            if(mid+1<=last)
            {
                root.right= right;
                call(i, mid+1, last, root.right);
            }
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        this.preorder= preorder;
        this.inorder= inorder;
        if(preorder.length==0)
            return null;
        map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i], i);
        
        TreeNode root=new TreeNode();
        call(new TreeNode(0), 0, inorder.length-1, root);
        return root;
    }
}
