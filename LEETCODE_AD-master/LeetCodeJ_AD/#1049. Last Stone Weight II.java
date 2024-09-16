package LeetCodeJ;// #1049. Last Stone Weight II



class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum= 0;
        for(int i: stones) sum+= i;
        
        boolean[] dp= new boolean[sum+1];
        dp[0]= true;
        for(int i: stones) {
            boolean[] temp= new boolean[sum+1];
            for(int j=0;j<sum+1;j++) {
                if(j< i) temp[j]= dp[j];
                else temp[j]|= dp[j]| dp[j-i];
            }
            
            dp= temp;
        }
        
        int ans= sum;
        for(int i=0;i<sum+1;i++) 
            if(dp[i]) ans= Math.min(ans, Math.abs(i- (sum-i)));
        
        return ans;
    }
}
