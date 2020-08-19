// 1162. As Far from Land as Possible 

class Solution {
    public int maxDistance(int[][] grid) 
    {
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
                if(grid[i][j]==1)
                { q.add(i); q.add(j); }
        }
        
        int ans=0, rowBound= grid.length-1, colBound= grid[0].length-1;
        boolean[][] seen=new boolean[grid.length][grid[0].length];
        
        while(!q.isEmpty() && q.size()/2!= grid.length* grid[0].length)
        {
            int size= q.size();
            
            for(int i=0;i<size/2;i++)
            {
                int row= q.poll(), col= q.poll();
                
                if(grid[max(row-1)][col]==0 && !seen[max(row-1)][col])
                { seen[max(row-1)][col]= true; q.add(max(row-1)); q.add(col); }
                
                if(grid[min(row+1, rowBound)][col]==0 && !seen[min(row+1, rowBound)][col])
                { seen[min(row+1, rowBound)][col]= true; q.add(min(row+1, rowBound)); q.add(col); }
                
                if(grid[row][max(col-1)]==0 && !seen[row][max(col-1)])
                { seen[row][max(col-1)]= true; q.add(row); q.add(max(col-1)); }
                
                if(grid[row][min(col+1, colBound)]==0 && !seen[row][min(col+1, colBound)])
                { seen[row][min(col+1, colBound)]= true; q.add(row); q.add(min(col+1, colBound)); }
            }
            
            ans++;
        }
        return ans-1;
    }
    
    static int max(int n)
    { return Math.max(0, n); }
    
    static int min(int n, int bound)
    { return Math.min(n , bound); }
}
