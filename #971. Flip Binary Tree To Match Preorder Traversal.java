// #971. Flip Binary Tree To Match Preorder Traversal



class Solution 
{
    List<Integer> ans;
    int curr;
    boolean call(TreeNode root, int[] voyage)
    {
        if(root== null) return true;
        if(root.val!= voyage[curr++])
            return false;
        
        if(root.left== null && root.right== null)
            return true;
        else if(root.left!= null && voyage[curr]== root.left.val)
        {
            boolean left= call(root.left, voyage);
            boolean right= call(root.right, voyage);
            return (left&& right);
        }
        else 
        {
            if(root.left!= null) ans.add(root.val);
            boolean right= call(root.right, voyage);
            boolean left= call(root.left, voyage);
            return (left&& right);
        }
    }
    
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) 
    {
        if(root== null)
            return new ArrayList<>();
        
        ans= new ArrayList<>();
        curr= 0;
        if(!call(root, voyage))
            return new ArrayList<>(Arrays.asList(-1));
        
        return ans;
    }
}
