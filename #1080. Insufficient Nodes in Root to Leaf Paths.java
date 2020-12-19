// #1080. Insufficient Nodes in Root to Leaf Paths



class Solution 
{
    int DFS(TreeNode root, int limit, int sum)
    {
        if(root== null)
            return limit-1;
        else
        {
            if(root.left== null && root.right== null)
                return sum+ root.val;
            
            int left= DFS(root.left, limit, sum+ root.val);
            int right= DFS(root.right, limit, sum+ root.val);
            //System.out.println("for root= "+root.val+" left= "+left+" right= "+right);
            if(left< limit)
                root.left= null;
            if(right< limit)
                root.right= null;
            
            return Math.max(left, right);
        }
    }
    
    public TreeNode sufficientSubset(TreeNode root, int limit) 
    {
        if(DFS(root, limit, 0)< limit)
            return null;
        else 
            return root;
    }
}
