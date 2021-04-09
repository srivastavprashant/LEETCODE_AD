// #764. Largest Plus Sign

// man this code is ugly someday add a better code than this.
class Solution {
    private int up= 0, down= 1, left= 2, right= 3;
    public int orderOfLargestPlusSign(int N, int[][] grid) {
        int[][][] dp= new int[N][N][4];
        int[][] mines= new int[N][N];
        for(int[] i: mines) Arrays.fill(i, 1);
        
        for(int[] i: grid) mines[i[0]][i[1]]= 0;
        
        for(int i=0;i<mines.length;i++) {
            int count= 0;
            for(int j=0;j<mines[0].length;j++) {
                if(mines[i][j]== 1) count++;
                else count= 0;
                dp[i][j][left]= count;    
            }
        }
        
        for(int i=0;i<mines.length;i++) {
            int count= 0;
            for(int j=mines[0].length-1;j>= 0; j--) {
                if(mines[i][j]== 1) count++;
                else count= 0;
                dp[i][j][right]= count;    
            }
        }
        
        for(int i=0;i<mines[0].length;i++) {
            int count= 0;
            for(int j=0;j<mines.length;j++) {
                if(mines[j][i]== 1) count++;
                else count= 0;
                dp[j][i][up]= count;    
            }
        }
        
        for(int i=0;i<mines[0].length;i++) {
            int count= 0;
            for(int j= mines.length-1;j>=0;j--) {
                if(mines[j][i]== 1) count++;
                else count= 0;
                dp[j][i][down]= count;    
            }
        }
        
        int ans= 0;
        for(int i=0;i<mines.length;i++) {
            for(int j=0;j<mines[0].length;j++) {
                ans= Math.max(ans, min(dp[i][j]));
            }
        }
        
        return ans;
    }
    
    private int min(int[] arr) {
        int ret= Math.min(arr[0], arr[1]);
        ret= Math.min(ret, arr[2]);
        ret= Math.min(ret, arr[3]);
        
        return ret;
    }
}
