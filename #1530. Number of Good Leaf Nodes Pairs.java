// 1530. Number of Good Leaf Nodes Pairs

class Solution 
{
    static int ans=0;
    static int[] postOrder(TreeNode root, int distance)
    {
        if(root!= null)
        {
            int[] left= postOrder(root.left, distance);
            int[] right= postOrder(root.right, distance);
            
            if(root.left!= null && root.right== null)
            {
                int[] ret= new int[11];
                for(int i=1;i<11;i++)
                    ret[i]= left[i-1];
                return ret;
            }
            
            else if(root.left== null && root.right!= null)
            {
                int[] ret= new int[11];
                for(int i=1;i<11;i++)
                    ret[i]= right[i-1];
                return ret;
            }
            
            else if(root.left==null && root.right== null)
                return new int[]{0,1,0,0,0,0,0,0,0,0,0};
            
            int[] ret= new int[11];
            for(int i=1;i<distance;i++)
            {
                for(int j=1;j<=distance-i;j++)
                    ans+= left[i]* right[j];
            }
            
            for(int i=1;i<11;i++)
                ret[i]= left[i-1]+ right[i-1];
            
            return ret;
        }
        else 
            return new int[]{0,0,0,0,0,0,0,0,0,0,0};
    }
    
    public int countPairs(TreeNode root, int distance) 
    {
        ans=0;
        postOrder(root, distance);
        
        return ans;
    }
}
