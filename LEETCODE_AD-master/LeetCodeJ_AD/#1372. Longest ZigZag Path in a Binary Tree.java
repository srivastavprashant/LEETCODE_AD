package LeetCodeJ;// #1372. Longest ZigZag Path in a Binary Tree



class Solution 
{
    int ans;
    int dfs(TreeNode root, boolean r)
    {
        if(root== null) return 0;
        else
        {
            int left= dfs(root.left, false);
            int right= dfs(root.right, true);
            ans= Math.max(ans, Math.max(1+left, 1+right));
            // System.out.println(ans+" "+root.val);
            
            return r? 1+left: 1+right;
        }
    }
    
    public int longestZigZag(TreeNode root) 
    {
        if(root.left== null && root.right== null) return 0;
        ans= 0;
        dfs(root, true);
        return ans-1;
    }
}
