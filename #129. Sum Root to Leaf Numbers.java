// 129. Sum Root to Leaf Numbers
class Solution 
{
    static int ans;
    static void call(TreeNode root, int sum)
    {
        if(root.left== null && root.right== null)
            ans+= sum;
        else
        {
            if(root.left!=null) call(root.left, sum*10+ root.left.val);
            if(root.right!=null) call(root.right, sum*10+ root.right.val);
        }
    }
    
    public int sumNumbers(TreeNode root) 
    {
        if(root== null)
            return 0;
        ans=0;
        call(root, root.val);
        return ans;
    }
}
