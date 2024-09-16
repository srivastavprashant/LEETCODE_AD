package LeetCodeJ;// #935. Knight Dialer



class Solution {
    private final int MOD= (int)1e9+ 7;
    private final int[][] adj= {{4, 6}, {6, 8}, {7, 9}, {8, 4}, {3, 9, 0}, {}, {0, 1, 7}, {2, 6}, {1 ,3}, {4, 2}, {}};
    public int knightDialer(int n) {
        int[][] dp= new int[n+1][10];
        Arrays.fill(dp[0], 1);
        
        for(int i= 1;i<=n;i++) {
            for(int j= 0;j<= 9;j++) {
                for(int k: adj[j])
                { 
                    dp[i][j]+= dp[i-1][k]; 
                    if(dp[i][j]>= MOD) dp[i][j]-= MOD;
                }
            }
        }
        
        int ans= 0;
        for(int i: dp[n-1])
        { ans+= i; if(ans>= MOD) ans-= MOD; }
        
        return ans;
    }
}
