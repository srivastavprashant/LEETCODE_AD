// 64. Minimum Path Sum


class Solution 
{
    static int[][] memo;
    static int call(int[][] grid, int row, int col)
    {
        if(row< grid.length && col< grid[0].length && memo[row][col]!=-1)
            return memo[row][col];
        
        else if(row< grid.length && col< grid[0].length)
        {
            int right= Integer.MAX_VALUE, down= Integer.MAX_VALUE;
            if(col+1< grid[0].length) right= call(grid, row, col+1);
            if(row+1< grid.length) down= call(grid, row+1, col);
            
            memo[row][col]= Math.min(right, down)+ grid[row][col]; 
            return memo[row][col];
        }
        else
            return 0;
    }
    
    public int minPathSum(int[][] grid) 
    {
        if(grid.length==0)
            return 0;
        
        memo= new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        Arrays.fill(memo[i], -1);
        memo[grid.length-1][grid[0].length-1]= grid[grid.length-1][grid[0].length-1];
        call(grid, 0, 0);
        return memo[0][0];
    }
}
