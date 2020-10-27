// 120. Triangle


class Solution 
{
    static int[][] memo;
    static int call(List<List<Integer>> list, int row, int col)
    {
        if(row< list.size() && memo[row][col]!=0)
            return memo[row][col];
        else if(row< list.size())
        {
            int left= call(list, row+1, col);
            int right= call(list, row+1, col+1);
            
            memo[row][col]= Math.min(left, right)+ list.get(row).get(col);
            return memo[row][col];
        }
        else
            return 0;
    }
    
    public int minimumTotal(List<List<Integer>> triangle) 
    {
        memo=new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        call(triangle, 0, 0);
        
        return memo[0][0];
    }
}
