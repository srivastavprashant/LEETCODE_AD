package LeetCodeJ;// #1382. Balance a Binary Search Tree

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
    static void inorder(TreeNode root, ArrayList<Integer> arr)
    {
        if(root!=null)
        {
            inorder(root.left, arr);
            arr.add(root.val);
            inorder(root.right, arr);
        }
    }
    
    static void build(TreeNode root, ArrayList<Integer> arr, int start, int last)
    {
        if(start<= last)
        {    
            int mid= start+ (last- start)/2;
            root.val= arr.get(mid);
            
            if(start<= mid-1)
            {
                TreeNode temp=new TreeNode();
                root.left= temp;
                build(temp, arr, start, mid-1);
            }
            
            if(mid+1<= last)
            {
                TreeNode temp=new TreeNode();
                root.right= temp;
                build(temp, arr, mid+1, last);
            }
        }
    }
    
    public TreeNode balanceBST(TreeNode root) 
    {
        ArrayList<Integer> arr=new ArrayList<>();
        inorder(root, arr);
        
        root=new TreeNode();
        build(root, arr, 0, arr.size()-1);
        return root;
    }
}
