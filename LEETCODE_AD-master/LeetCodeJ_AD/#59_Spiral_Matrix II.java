package LeetCodeJ;/*
  Question Link: https://leetcode.com/problems/spiral-matrix-ii
  Approach: for simplicity purpose we have used directions to rotate 90 degree as soon as we get a value that is not 0, which basically suggests that we have 
  already updated its value.
  
  This beautifull logic can be found in the discuss section of the question.
 */

class Solution {
    public int[][] generateMatrix(int n) 
    {
        int[][] ans=new int[n][n];
        int i=0, j=0, di=0, dj=1;
        for(int val=1;val<=n*n; val++, i+=di, j+=dj)
        {
            ans[i][j]= val;
            
            if(ans[Math.abs((i+di)%n)][Math.abs((j+dj)%n)]!=0)
            {
                int swap= di;
                di= dj;
                dj= -1*swap;
            }
        }
        return ans;
    }
}
