package LeetCodeJ;// #417. Pacific Atlantic Water Flow


class Solution 
{
    public List<List<Integer>> pacificAtlantic(int[][] matrix) 
    {
        if(matrix.length== 0)
            return new ArrayList<>();
        Queue<Integer> q= new LinkedList<>();        
        boolean[][] visited= new boolean[matrix.length][matrix[0].length];
        boolean[][] atlantic= new boolean[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++)
        { q.add(i); q.add(0); visited[i][0]= true; }
        
        for(int i=0;i<matrix[0].length;i++)
        { q.add(0); q.add(i); visited[0][i]= true; }
    
        bfs(matrix, atlantic, q, visited);
        
        visited= new boolean[matrix.length][matrix[0].length];
        boolean[][] pacific= new boolean[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++)
        { q.add(i); q.add(matrix[0].length-1); visited[i][matrix[0].length-1]= true; }
        
        for(int i=0;i<matrix[0].length;i++)
        { q.add(matrix.length-1); q.add(i); visited[matrix.length-1][i]= true; }
        
        bfs(matrix, pacific, q, visited);
        
        List<List<Integer>> ans= new ArrayList<>();
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++)
                if(atlantic[i][j] && pacific[i][j])
                    ans.add(new ArrayList<>(Arrays.asList(i, j)));
        
        return ans;
    }
    
    static void bfs(int[][] matrix, boolean[][] ocean, Queue<Integer> q, boolean[][] visited)
    {
        while(!q.isEmpty())
        {
            int size= q.size();
            
            for(int i=0;i<size/2;i++)
            {
                int row= q.poll();
                int col= q.poll();
                ocean[row][col]= true;
                
                if(row-1>=0 && !visited[row-1][col] && matrix[row-1][col]>= matrix[row][col])
                { visited[row-1][col]= true; q.add(row-1); q.add(col); }
                
                if(row+1<matrix.length && !visited[row+1][col] && matrix[row+1][col]>= matrix[row][col])
                { visited[row+1][col]= true; q.add(row+1); q.add(col); }
                
                if(col-1>=0 && !visited[row][col-1] && matrix[row][col-1]>= matrix[row][col])
                { visited[row][col-1]= true; q.add(row); q.add(col-1); }
                
                if(col+1<matrix[0].length && !visited[row][col+1] && matrix[row][col+1]>= matrix[row][col])
                { visited[row][col+1]= true; q.add(row); q.add(col+1); }
            }
        }
    }
}
