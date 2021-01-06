// #889. Construct Binary Tree from Preorder and Postorder Traversal



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
    int index;
    HashMap<Integer, Integer> map;
    void call(int[] pre, TreeNode root)
    {
        if(index== pre.length) return;
        
        root.val= pre[index];
        int val= pre.length;
        
        if(index+1!= pre.length)
            val= map.get(pre[index+1]);
        
        if(val< map.get(root.val))
        {
            TreeNode left= new TreeNode();
            root.left= left;
            index++;
            call(pre, left);
        }
        else
            return;
        
        val= pre.length;
        if(index+1!= pre.length)
            val= map.get(pre[index+1]);
        
        if(val< map.get(root.val))
        {
            TreeNode right= new TreeNode();
            root.right= right;
            index++;
            call(pre, right);
        }
        else
            return;   
    }
    
    
    public TreeNode constructFromPrePost(int[] pre, int[] post) 
    {
        index= 0;
        if(pre.length== 0) return null;
        map= new HashMap<>();
        for(int i=0;i<post.length;i++)
            map.put(post[i], i);
        
        TreeNode root= new TreeNode();
        call(pre, root);
                
        return root;
    }
}
