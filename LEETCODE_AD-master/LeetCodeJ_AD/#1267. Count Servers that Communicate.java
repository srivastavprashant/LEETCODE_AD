package LeetCodeJ;// 1267. Count Servers that Communicate


class Solution 
{
    static int ans;
    static void DFSREC(int[][] arr, boolean[][] visited, int row, int col)
    {
        visited[row][col]= true;
        ans++;
        
        for(int i=0;i<arr[0].length;i++)
            if(visited[row][i] || arr[row][i]==0) 
                continue;
            else
                DFSREC(arr, visited, row, i);
        
        for(int i=0;i<arr.length;i++)
            if(visited[i][col] || arr[i][col]==0) 
                continue;
            else
                DFSREC(arr, visited, i, col);
    }
    
    public int countServers(int[][] grid) 
    {
        boolean[][] visited= new boolean[grid.length][grid[0].length];
        ans=0;
        int val=0;
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(visited[i][j] || grid[i][j]==0) continue;
                
                val=ans;
                DFSREC(grid, visited, i, j);
                if(val== ans-1)
                    ans--;
            }
        }
        
        return ans;
    }
}
