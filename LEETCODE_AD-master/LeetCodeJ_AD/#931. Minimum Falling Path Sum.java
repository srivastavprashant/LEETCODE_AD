package LeetCodeJ;// #931. Minimum Falling Path Sum


class Solution 
{
    int[][] memo;
    int call(int[][] matrix, int row, int col)
    {
        if(col>= matrix[0].length || col<0)
            return Integer.MAX_VALUE;
        else if(row== matrix.length-1) return matrix[row][col];
        else if(memo[row][col]!= Integer.MIN_VALUE) return memo[row][col];
        else
        {
            int min= Integer.MAX_VALUE;
            min= Math.min(min, call(matrix, row+1, col));
            min= Math.min(min, call(matrix, row+1, col-1));
            min= Math.min(min, call(matrix, row+1, col+1));
            
            memo[row][col]= min+ matrix[row][col];
            return memo[row][col];
        }
    }
    
    public int minFallingPathSum(int[][] matrix) 
    {
        memo= new int[matrix.length][matrix[0].length];
        for(int[] i: memo)
            Arrays.fill(i, Integer.MIN_VALUE);
        
        int ans= Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++)
            ans= Math.min(ans, call(matrix, 0, i));
        
        return ans;
    }
}
