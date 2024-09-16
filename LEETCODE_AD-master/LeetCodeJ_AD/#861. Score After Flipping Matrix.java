package LeetCodeJ;

class Solution {
    public int matrixScore(int[][] grid) {
        int ans = 0;
        for(int i=0;i<grid.length;i++) {
            if(grid[i][0] == 0) flipRow(grid, i);
        }
        
        for(int i=0;i<grid[0].length;i++) {
            int count =0;
            for(int j=0;j<grid.length;j++) {
                count+= grid[j][i];
            }
            if(count< grid.length-count) flipCol(grid, i);
        }
        
        for(int i=0;i<grid.length;i++) {
            int n= 0;
            for(int j=0;j<grid[0].length;j++) {
                n= n<<1 | grid[i][j];
            }
            ans+= n;
        }
        
        return ans;
    }
    
    public void flipRow(int[][] grid, int row) {
        for(int i=0;i<grid[0].length;i++) grid[row][i]= (grid[row][i] + 1)% 2;
    }
    
    public void flipCol(int[][] grid, int col) {
        for(int i=0;i<grid.length;i++) grid[i][col]= (grid[i][col] + 1)% 2;
    }
}
