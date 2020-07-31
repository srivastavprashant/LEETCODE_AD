// 718. Maximum Length of Repeated Subarray
class Solution {
    public int findLength(int[] A, int[] B) 
    {
        int[][] dp=new int[A.length+1][B.length+1];
        int A_len= A.length, B_len= B.length;
        for(int i=A_len-1; i>=0;i--)
            for(int j= B_len-1; j>=0;j--)
                if(A[i]==B[j])
                    dp[i][j]= dp[i+1][j+1]+ 1;
        
        int max= 0;
        for(int i=0;i<=A_len;i++)
            for(int j=0;j<=B_len;j++)
                max= Math.max(max, dp[i][j]);
        
        return max;
    }
}
