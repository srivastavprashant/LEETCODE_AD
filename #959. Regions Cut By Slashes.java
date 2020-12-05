#959. Regions Cut By Slashes


Approach: (Depth first search)
class Solution 
{
    static void DFSREC(char[][] grid, boolean[][][] visited, int row, int col, int type)
    {
        visited[row][col][type]= true;
        
        // within the same row and col
        for(int i=0;i<4;i++)
        {
            if(visited[row][col][i] || type== i || type== (i+2)%4)
                continue;
            
            if(grid[row][col]== '/' && ((type== 2 && i== 3) || (type== 1 && i== 0) || (type== 3 && i== 2) || (type== 0 && i== 1))) continue;
               
            if(grid[row][col]== '\\' && ((type== 2 && i== 1) || (type== 1 && i== 2) || (type== 3 && i== 0) || (type== 0 && i== 3))) continue;
                
            
            DFSREC(grid, visited, row, col, i);
        }
        
        // outside the cell
        if(type== 0)
            if(row-1>-1 && !visited[row-1][col][2])
                DFSREC(grid, visited, row-1, col, 2);
        
        if(type== 1)
            if(col+1< grid[0].length && !visited[row][col+1][3])
                DFSREC(grid, visited, row, col+1, 3);
        
        if(type== 2)
            if(row+1< grid.length && !visited[row+1][col][0])
                DFSREC(grid, visited, row+1, col, 0);
        
        if(type== 3)
            if(col-1> -1 && !visited[row][col-1][1])
                DFSREC(grid, visited, row, col-1, 1);
    }

    public int regionsBySlashes(String[] _grid)
    {
        boolean[][][] visited= new boolean[_grid.length][_grid[0].length()][4];
        char[][] grid= new char[_grid.length][];
        
        for(int i=0;i<_grid.length;i++)
            grid[i]= _grid[i].toCharArray();
        
        int regions= 0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                for(int type= 0;type<4;type++)
                {
                    if(visited[i][j][type]) continue;
                    DFSREC(grid, visited, i, j, type);
                    regions++;
                }
            }
        }
        
        return regions;
    }
}
