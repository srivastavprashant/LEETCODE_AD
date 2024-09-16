package LeetCodeJ;

class Solution {
    public int projectionArea(int[][] grid) {
        return top(grid)+ left(grid)+ right(grid);   
    }
    
    int top(int[][] grid) {
        int ret= 0;
        for(int[] i: grid) 
            for(int j: i) ret+= j== 0? 0: 1;
        return ret;
    }
    
    int left(int[][] grid) {
        int ret= 0;
        for(int[] i: grid) {
            int val= 0;
            for(int j: i) val= Math.max(j, val);
            ret+= val;
        }
        
        return ret;
    }
    
    int right(int[][] grid) {
        int ret= 0;
        for(int i=0;i<grid[0].length;i++) {
            int val= 0;
            for(int j=0;j<grid.length;j++) val= Math.max(grid[j][i], val);
            ret+= val;
        }
        
        return ret;
    }
}
