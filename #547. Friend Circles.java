// 547. Friend Circles

class Solution 
{
    static void DFSREC(int[][] arr, boolean[] visited, int i)
    {
        visited[i]= true;
        
        for(int j=0;j<arr[i].length;j++)
            if(!visited[j] && arr[i][j]==1)
                DFSREC(arr, visited, j);
    }
    
    public int findCircleNum(int[][] M) 
    {
        boolean[] visited= new boolean[M.length];
        int ans=0;
        
        for(int i=0;i<M.length;i++)
        {
            if(!visited[i])
            {
                DFSREC(M, visited, i);
                ans++;
            }
        }
        return ans;
    }
}
