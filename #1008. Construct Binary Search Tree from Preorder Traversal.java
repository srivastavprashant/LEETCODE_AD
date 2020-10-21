// 1008. Construct Binary Search Tree from Preorder Traversal


class Solution 
{
    static void call(int[] arr, int start, int last, TreeNode root)
    {
        if(start<= last)
        {
            root.val= arr[start];
            
            int i;
            for(i= start;i<= last;i++)
                if(arr[start]< arr[i])
                    break;
            
            if(start+1<= i-1)
            {
                TreeNode left= new TreeNode();
                root.left= left;
                call(arr, start+1, i-1, root.left);
            }
            
            if(i<= last)
            {
                TreeNode right= new TreeNode();
                root.right= right;
                call(arr, i, last, root.right);
            }
        }
    }
    
    public TreeNode bstFromPreorder(int[] preorder) 
    {
        TreeNode root= new TreeNode();
        call(preorder, 0, preorder.length-1, root);
        
        return root;
    }
}
