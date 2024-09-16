package LeetCodeJ;// #1155. Number of Dice Rolls With Target Sum


class Solution {
    private final int MOD= 1000000007;
    public int numRollsToTarget(int d, int f, int target) {
        int[][] dp= new int[d+1][target+1]; dp[0][0]= 1;
        
        for(int i=1;i<= d;i++) {
            for(int j= 1;j<= target;j++) {
                for(int val= 1;val<= f;val++) {
                    if(j- val< 0) break;
                    dp[i][j]+= dp[i-1][j-val];
                    if(dp[i][j]>= MOD) dp[i][j]-= MOD;
                }
            }
        }
                
        return dp[d][target];
    }
}
