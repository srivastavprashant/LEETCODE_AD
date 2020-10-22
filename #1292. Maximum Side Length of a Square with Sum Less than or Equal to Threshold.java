//1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold

/*
    This problem was of presum approach on a 2 dimensional array.
    So basically in Presum array of a 2D matrix each cell, let say
    presum[i][j] contains the sum of the matrix starting from (0, 0) to (i, j).
    
    The formula to calculate the presum is arr[i][j]+ presum[i-1][j]+ presum[i][j-1]- presum[i-1][j-1].
    Now when we have an effictive way to calculate the square sum.
    Traverse the matrix and from each cell extend the matrix until it violates the threshold or maybe u reach end of row or col.
*/


class Solution {
    public int maxSideLength(int[][] mat, int threshold) 
    {
        int[][] presum= new int[mat.length+1][mat[0].length+1];
        for(int i=1;i<presum.length;i++)
            for(int j=1;j<presum[0].length;j++)
                presum[i][j]= mat[i-1][j-1]+ presum[i-1][j]+ presum[i][j-1]- presum[i-1][j-1];
        
        
        int ans= 0;
        for(int i=1;i<presum.length;i++)
        {
            for(int j=1;j<presum[0].length;j++)
            {
                for(int k=ans;k<Math.min(presum.length-i, presum[0].length-j);k++)
                {
                    int row= i+k, col= j+k;
                    int val= presum[row][col]- presum[i-1][col]- presum[row][j-1]+ presum[i-1][j-1];
                    if(threshold>= val)
                        ans= Math.max(ans, k+1);
                    else
                        break;
                }
            }
        }
        
        return ans;
    }
}
