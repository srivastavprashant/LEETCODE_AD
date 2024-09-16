package LeetCodeJ;// 1254. Number of Closed Islands

class Solution 
{
    static boolean leak;
    static void DFSREC(int[][] grid, boolean[][] visited, int row, int col)
    {
        visited[row][col]= true;
        
        if(row-1!=-1 && !visited[row-1][col] && grid[row-1][col]==0)
            DFSREC(grid, visited, row-1, col);
        else if(row-1== -1)
            leak= true;
        
        if(row+1!=grid.length && !visited[row+1][col] && grid[row+1][col]==0)
            DFSREC(grid, visited, row+1, col);
        else if(row+1== grid.length)
            leak= true;
        
        if(col-1!=-1 && !visited[row][col-1] && grid[row][col-1]==0)
            DFSREC(grid, visited, row, col-1);
        else if(col-1== -1)
            leak= true;
        
        if(col+1!= grid[0].length && !visited[row][col+1] && grid[row][col+1]==0)
            DFSREC(grid, visited, row, col+1);
        else if(col+1== grid[0].length)
            leak= true;
    }
    
    public int closedIsland(int[][] grid) 
    {
        boolean[][] visited= new boolean[grid.length][grid[0].length];
        int ans=0;
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                leak= false;
                if(!visited[i][j] && grid[i][j]==0)
                {
                    DFSREC(grid, visited, i, j);
                    ans+= leak? 0: 1;
                }
            }
        }
        return ans;
    }
}
