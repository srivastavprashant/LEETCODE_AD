//1091. Shortest Path in Binary Matrix

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) 
    {
        int len=1;
        Queue<Integer> q=new LinkedList<>();
        boolean[][] seen= new boolean[grid.length][grid[0].length];
        seen[0][0]= true;
        
        if(grid[0][0]==0)
        { q.add(0); q.add(0); }
        
        while(!q.isEmpty())
        {
            int size= q.size();
            
            for(int i=0;i<size/2;i++)
            {
                int row= q.poll();
                int col= q.poll();
                if(row== grid.length-1 && col== grid[0].length-1)
                    return len;
                
                for(int r=Math.max(0, row-1);r<=Math.min(grid.length-1, row+1);r++)
                {
                    for(int c=Math.max(0, col-1);c<=Math.min(grid[0].length-1, col+1);c++)
                    {
                        if(r== row && c== col) continue;
                        
                        if(grid[r][c]==0 && !seen[r][c])
                        { q.add(r); q.add(c); seen[r][c]= true; }
                    }
                }
            }
            len++;
        }       
        return -1;
    }
}
