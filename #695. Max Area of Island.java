// 695. Max Area of Island

class Solution 
{
    static int max, curr;
    static void DFSREC(int[][] grid, boolean[][] visited, int row, int col)
    {
        visited[row][col]= true;
        curr++;
        
        if(row-1!=-1 && !visited[row-1][col] && grid[row-1][col]==1)
            DFSREC(grid, visited, row-1, col);
        
        if(row+1!=grid.length && !visited[row+1][col] && grid[row+1][col]==1)
            DFSREC(grid, visited, row+1, col);
        
        if(col-1!=-1 && !visited[row][col-1] && grid[row][col-1]==1)
            DFSREC(grid, visited, row, col-1);
        
        if(col+1!= grid[0].length && !visited[row][col+1] && grid[row][col+1]==1)
            DFSREC(grid, visited, row, col+1);
        
        max= Math.max(max, curr);
    }
    
    public int maxAreaOfIsland(int[][] grid) 
    {
        boolean[][] visited= new boolean[grid.length][grid[0].length];
        max= 0;
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                curr=0;
                if(!visited[i][j] && grid[i][j]==1)
                    DFSREC(grid, visited, i, j);
            }
        }
        return max;
    }
}
