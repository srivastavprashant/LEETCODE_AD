// #1034. Coloring A Border



class Solution 
{
    boolean call(int[][] grid, boolean[][] visited, int row, int col, int color, int component)
    {
        if(row>= grid.length || row<0 || col>= grid[0].length || col<0)
            return true;
        else if(visited[row][col])
            return false;
        else if(grid[row][col]!= component)
            return true;
        
        visited[row][col]= true;
        boolean should_i_color= call(grid, visited, row+1, col, color, component);
        should_i_color|= call(grid, visited, row-1, col, color, component);
        should_i_color|= call(grid, visited, row, col+1, color, component);
        should_i_color|= call(grid, visited, row, col-1, color, component);
        
        if(should_i_color)
            grid[row][col]= color;
        return false;
    }
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) 
    {
        boolean[][] visited= new boolean[grid.length][grid[0].length];
        call(grid, visited, r0, c0, color, grid[r0][c0]);
        
        return grid;
    }
}
