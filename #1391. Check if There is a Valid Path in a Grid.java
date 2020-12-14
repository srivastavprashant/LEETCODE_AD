// #1391. Check if There is a Valid Path in a Grid


class Solution 
{
    static boolean ans;
    static void DFSREC(int[][] graph, boolean[][] visited, int row, int col, int direction)
    {
        //System.out.println(row+" "+col+" "+ direction);
        if(row<0 || col<0 || row>= graph.length || col>= graph[0].length|| visited[row][col])
            return; 
        
        if(direction== 1 && (graph[row][col]!=3 && graph[row][col]!= 5&& graph[row][col]!= 1))
            return;
        
        if(direction== 2 && (graph[row][col]!=6 && graph[row][col]!=4 && graph[row][col]!=1 ))
            return;
        
        if(direction== 3 && (graph[row][col]!=3 && graph[row][col]!= 4 && graph[row][col]!= 2))
            return;
        
        if(direction== 4 && (graph[row][col]!=6 && graph[row][col]!= 5 && graph[row][col]!= 2))
            return;
            
        
        if(row== graph.length-1 && col== graph[0].length-1)
            ans= true;
        
        visited[row][col]= true;
        
        if(graph[row][col]== 1)
        {
            DFSREC(graph, visited, row, col-1, 2);
            DFSREC(graph, visited, row, col+1, 1);
        }
        else if(graph[row][col]== 2)
        {
            DFSREC(graph, visited, row+1, col, 4);
            DFSREC(graph, visited, row-1, col, 3);
        }
        else if(graph[row][col]== 3)
        {
            DFSREC(graph, visited, row, col-1, 2);
            DFSREC(graph, visited, row+1, col, 4);
        }
        else if(graph[row][col]== 4)
        {
            DFSREC(graph, visited, row, col+1, 1);
            DFSREC(graph, visited, row+1, col, 4);
        }
        else if(graph[row][col]== 5)
        {
            DFSREC(graph, visited, row, col-1, 2);
            DFSREC(graph, visited, row-1, col, 3);
        }
        else
        {
            DFSREC(graph, visited, row, col+1, 1);
            DFSREC(graph, visited, row-1, col, 3);
        }
            
    }
    public boolean hasValidPath(int[][] grid) 
    {
        ans= false;
        boolean[][] visited= new boolean[grid.length][grid[0].length];
        DFSREC(grid, visited, 0, 0, -1);
        
        return ans;
    }
}
