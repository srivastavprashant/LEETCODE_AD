// #1139. Largest 1-Bordered Square



class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int[][] left= new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++) {
            int count= 0;
            for(int j= 0;j<grid[0].length;j++) {
                if(grid[i][j]== 1) count++;
                else count= 0;
                
                left[i][j]= count;
            }
        }
        
        int[][] up= new int[grid.length][grid[0].length];
        for(int i=0;i<grid[0].length;i++) {
            int count= 0;
            for(int j= 0;j<grid.length;j++) {
                if(grid[j][i]== 1) count++;
                else count= 0;
                
                up[j][i]= count;
            }
        }
        
        int ans= 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                for(int len= 0;len<=Math.min(i, j);len++) {
                    if(up[i][j]> len && left[i][j]> len && up[i][j-len]> len && left[i- len][j]> len)
                        ans= Math.max(ans, len+1);
                }
            }
        }
        
        return ans*ans;
    }
}
