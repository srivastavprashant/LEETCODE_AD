#1260


class Solution 
{
    public List<List<Integer>> shiftGrid(int[][] grid, int k) 
    {
        int size= grid.length* grid[0].length;
        int row= grid.length, col= grid[0].length;
        List<List<Integer>> ans= new ArrayList<>();
        for(int i=0;i<grid.length;i++)
        {
            List<Integer> temp= new ArrayList<>();
            for(int j=0;j<grid[0].length;j++)
                temp.add(0);
            ans.add(temp);
        }
        
        for(int i=0;i<size;i++)
        {
            int[] index= index((k+ i)%size, row, col); //final
            int[] index_grid= index(i, row, col); // actual
            ans.get(index[0]).set(index[1], grid[index_grid[0]][index_grid[1]]);
        }
        
        return ans;
    }
    
    int[] index(int n, int row, int col)
    { return new int[]{n/col, n%col}; }
}
