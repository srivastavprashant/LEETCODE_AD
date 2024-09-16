package LeetCodeJ;// 1020. Number of Enclaves


class Solution 
{
    static int area;
    static boolean island;
    
    static void DFSREC(int[][] arr, boolean[][] visited, int row, int col)
    {
        visited[row][col]= true;
        area++;
        
        if(row-1!=-1 && !visited[row-1][col] && arr[row-1][col]==1)
            DFSREC(arr, visited, row-1, col);
        else if(row-1 == -1)
            island= false;
        
        if(row+1!= arr.length && !visited[row+1][col] && arr[row+1][col]==1)
            DFSREC(arr, visited, row+1, col);
        else if(row+1 == arr.length)
            island= false;
        
        if(col-1!=-1 && !visited[row][col-1] && arr[row][col-1]==1)
            DFSREC(arr, visited, row, col-1);
        else if(col-1 == -1)
            island= false;
        
        if(col+1!= arr[0].length && !visited[row][col+1] && arr[row][col+1]==1)
            DFSREC(arr, visited, row, col+1);
        else if(col+1 == arr[0].length)
            island= false;
    }
    
    public int numEnclaves(int[][] A) 
    {
        boolean[][] visited= new boolean[A.length][A[0].length];
        int ans=0;
        
        for(int i=0;i<A.length;i++)
        {
            for(int j=0;j<A[0].length;j++)
            {
                if(!visited[i][j] && A[i][j]==1)
                {
                    island= true;
                    area=0;
                    
                    DFSREC(A, visited, i, j);
                    if(island)
                        ans+= area;
                }
            }
        }
        
        return ans;
    }
}
