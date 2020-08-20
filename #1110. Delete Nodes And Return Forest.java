//1110. Delete Nodes And Return Forest

class Solution 
{
    static List<TreeNode> ans;
    static HashSet<Integer> set;
    
    static void call(TreeNode root, TreeNode parent, int flag)
    {
        if(root!=null)
        {
            call(root.left, root, 0);
            call(root.right, root, 1);
            
            if(set.contains(root.val))
            {
                if(parent!=null)
                {
                    if(flag==0) parent.left= null;
                    else parent.right= null;
                }
                
                if(root.left!=null)
                    ans.add(root.left);
                
                if(root.right!=null)
                    ans.add(root.right);
            }
            
        }
    }
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) 
    {
        ans= new ArrayList<>();
        set= new HashSet<>();
        
        for(int i: to_delete)
            set.add(i);
        
        if(!set.contains(root.val))
            ans.add(root);
            
        call(root, null, 0);
        return ans;
    }
}
