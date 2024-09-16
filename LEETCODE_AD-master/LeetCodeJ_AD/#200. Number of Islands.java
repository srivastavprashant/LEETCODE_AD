package LeetCodeJ;// #200. Number of Islands



class Solution 
{
    static void DFSREC(char[][] grid, boolean[][] visited, int row, int col)
    {
        visited[row][col]= true;
        
        if(!visited[Math.max(0, row-1)][col] && grid[Math.max(0, row-1)][col]== '1')
            DFSREC(grid, visited, Math.max(0, row-1), col);
        
        if(!visited[Math.min(grid.length-1, row+1)][col] && grid[Math.min(grid.length-1, row+1)][col]== '1')
            DFSREC(grid, visited, Math.min(grid.length-1, row+1), col);
        
        if(!visited[row][Math.max(0, col-1)] && grid[row][Math.max(0, col-1)]== '1')
            DFSREC(grid, visited, row, Math.max(0, col-1));
    
        if(!visited[row][Math.min(grid[0].length-1, col+1)] && grid[row][Math.min(grid[0].length-1, col+1)]== '1')
            DFSREC(grid, visited, row, Math.min(grid[0].length-1, col+1));
    }
    public int numIslands(char[][] grid) 
    {
        int islands= 0;
        boolean[][] visited= new boolean[grid.length][grid[0].length];
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]== '0' || visited[i][j]) continue;
                
                DFSREC(grid, visited, i, j);
                islands++;
            }
        }
        
        return islands;
    }
}
