// 1572. Matrix Diagonal Sum

class Solution {
    public int diagonalSum(int[][] mat) 
    {
        int ans=0;
        for(int i=0;i<mat.length;i++)
            ans+= mat[i][i]+ (i!=(mat.length-i-1)? mat[i][mat.length-1-i]: 0);
        
        return ans;        
    }
}
