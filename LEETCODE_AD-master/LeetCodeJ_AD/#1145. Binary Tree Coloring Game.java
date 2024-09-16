package LeetCodeJ;// 1145. Binary Tree Coloring Game

class Solution 
{
    static int Left, Right;
    static int postOrder(TreeNode root, int x)
    {
        if(root!=null)
        {
            int left= postOrder(root.left, x);
            int right= postOrder(root.right, x);
            
            if(x== root.val)
            {
                Left= left;
                Right= right;
                return 0;
            }
            else
                return left+ right+ 1;
        }
        else
            return 0;
    }
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) 
    {
        Left=0;
        Right=0;
        int parent= postOrder(root, x);
        
        if(Left> (parent+ Right+ 1) || Right> (parent+ Left+ 1) || parent> (Left+ Right+ 1))
            return true;
        else
            return false;
    }
}
