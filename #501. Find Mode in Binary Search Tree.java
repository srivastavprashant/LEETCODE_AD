// 501. Find Mode in Binary Search Tree

class Solution 
{
    static int max, size, count, prev;
    static void find(TreeNode root)
    {
        if(root== null)
            return ;
        else
        {
            find(root.left);
        
            if(prev== root.val)
                count++;
            else
            {
                count=1;
                prev= root.val;
            }
            if(count>max)
            { max= count; size=1; }
            else if(max== count)
                size++;
        
            find(root.right);
        }
    }
    
    static int index;
    static void fill(TreeNode root, int[] ans)
    {
        if(root== null)
            return ;
        else
        {
            fill(root.left, ans);
            
            if(prev== root.val)
                count++;
            else
            {
                count=1;
                prev= root.val;
            }
        
            if(count== max)
                ans[index++]= root.val;

            fill(root.right, ans);
        }
    }
    public int[] findMode(TreeNode root) 
    {
        prev=-1;
        count=1;
        max=0;
        size=0;
        find(root);
        
        int[] ans= new int[size];
        count=1;
        prev= -1;
        index=0;
        fill(root, ans);
        
        return ans;
    }
}
