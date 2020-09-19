// 1026. Maximum Difference Between Node and Ancestor
class Solution 
{
    static int ans;
    
    static void DFSREC(TreeNode root, int min, int max)
    {
        if(root!=null)
        {
            ans= Math.max(ans, Math.abs(max- root.val));
            ans= Math.max(ans, Math.abs(min- root.val));
            max= Math.max(root.val, max);
            min= Math.min(min, root.val);
            
            DFSREC(root.left, min ,max);
            DFSREC(root.right, min, max);
        }
    }
    
    public int maxAncestorDiff(TreeNode root) 
    {
        if(root==null)
            return 0;
        
        ans= 0;
        DFSREC(root, root.val, root.val);
        
        return ans;
    }
}
