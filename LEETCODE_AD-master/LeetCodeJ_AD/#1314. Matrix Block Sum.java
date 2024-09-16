package LeetCodeJ;// 1314. Matrix Block Sum


class Solution 
{
    public int[][] matrixBlockSum(int[][] mat, int k) 
    {
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
                mat[i][j]+= (i!=0? mat[i-1][j]: 0) + (j!=0? mat[i][j-1]: 0)- (i!=0 && j!=0? mat[i-1][j-1]: 0);
        }
            
        int[][] ans= new int[mat.length][mat[0].length];
        int row= mat.length-1, col= mat[0].length-1;
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                ans[i][j]= mat[Math.min(i+k, row)][Math.min(j+k, col)]- (i-k-1>=0? mat[i-k-1][Math.min(j+k, col)]:0);
                ans[i][j]= ans[i][j]- (j-k-1>=0? mat[Math.min(i+k, row)][j-k-1]: 0)+ ((i-k-1>=0 && j-k-1>=0)? mat[i-k-1][j-k-1]: 0);
            }
        }
        
        return ans;
    }
}
