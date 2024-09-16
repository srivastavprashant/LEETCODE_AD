package LeetCodeJ;// 62. Unique Paths


class Solution 
{
    static int[][] memo;
    static int call(int m, int n, int row, int col)
    {
        if(row<m && col< n && memo[row][col]!=-1)
            return memo[row][col];
        else if(row< m && col< n)
        {
            int right= call(m, n, row, col+1);
            int down= call(m, n, row+1, col);
            memo[row][col]= right+ down;
            
            return memo[row][col];
        }
        else
            return 0;
    }
    
    public int uniquePaths(int m, int n) 
    {
        memo= new int[m][n];
        
        for(int i=0;i<m;i++)
            Arrays.fill(memo[i], -1);
        
        memo[m-1][n-1]= 1;
        
        call(m, n, 0, 0);
        return memo[0][0];        
    }
}
