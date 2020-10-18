//106. Construct Binary Tree from Inorder and Postorder Traversal


// For further optimizations we can use a hashMaps to find the index for the number in inorder traversal array 
// rather than using the linear search technique.

class Solution 
{
    static int index;
    static void call(int[] inorder, int[] postorder, int start, int last, TreeNode root)
    {
        if(index>=0)
        {
            int mid= search(inorder, postorder[index]);
            root.val= postorder[index];
            //System.out.println(mid);
            index--;
           
            if(mid< last)
            {
                TreeNode right= new TreeNode();
                root.right= right;
                
                call(inorder, postorder, mid+1, last, right);
            }
            
            if(start<mid)
            {
                TreeNode left= new TreeNode();
                root.left= left;
                
                call(inorder, postorder, start, mid-1, left);
            }
        }
    }
    
    static int search(int[] arr, int find)
    {
        for(int i=0;i<arr.length;i++)
            if(find== arr[i])
                return i;
        
        return -1;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
        if(inorder.length==0)
            return null;
        TreeNode root= new TreeNode();
        index= inorder.length-1;
        call(inorder, postorder, 0, inorder.length-1, root);
        
        return root;
    }
}
