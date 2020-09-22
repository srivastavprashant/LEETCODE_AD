// 1123. Lowest Common Ancestor of Deepest Leaves
class Solution 
{
    static int max;
    static TreeNode ans;
    static int call(TreeNode root, int height)
    {
        if(root!=null)
        {
            int left= call(root.left, height+1);
            int right= call(root.right, height+1);
            
            if(left== right)
            {
                if(height+ left >= max)
                { max= height+ left; ans= root; }
            }
            
            return Math.max(left, right)+1;
        }
        else
            return 0;
    }
    
    public TreeNode lcaDeepestLeaves(TreeNode root) 
    {
        max= 0;
        ans= null;
        
        call(root, 0);
        return ans;
    }
}
