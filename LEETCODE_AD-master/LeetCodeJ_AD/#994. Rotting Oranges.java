package LeetCodeJ;// 994. Rotting Oranges

class Solution {
    public int orangesRotting(int[][] grid) 
    {
        int rowBound= grid.length-1, colBound= grid[0].length-1;
        int fresh=0;
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                if(grid[i][j]==2) { q.add(i); q.add(j);}
                else if(grid[i][j]==1)
                    fresh++;
        
        int time=0;
        while(fresh!=0 && !q.isEmpty())
        {
            int size= q.size();
            
            for(int i=0;i<size/2;i++)
            {
                int row= q.poll(), col= q.poll();
            
                if(grid[max(row-1)][col]== 1)
                {
                fresh--;
                grid[max(row-1)][col]= 2;
                q.add(max(row-1));
                q.add(col);
            }
            
                if(grid[min(row+1, rowBound)][col]== 1)
                {
                fresh--;
                grid[min(row+1, rowBound)][col]= 2;
                q.add(min(row+1, rowBound));
                q.add(col);
            }
            
                if(grid[row][min(col+1, colBound)]== 1)
                {
                fresh--;
                grid[row][min(col+1, colBound)]= 2;
                q.add(row);
                q.add(min(col+1, colBound));
            } 
            
                if(grid[row][max(col-1)]== 1)
                {
                fresh--;
                grid[row][max(col-1)]= 2;
                q.add(row);
                q.add(max(col-1));
            }
            }
            time++;
        }
        
        return fresh==0? time: -1;
    }
    
    static int max(int i)
    { return Math.max(0, i); }
    
    static int min(int i, int bound)
    { return Math.min(bound, i); }
}
