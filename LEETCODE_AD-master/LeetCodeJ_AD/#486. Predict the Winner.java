package LeetCodeJ;// #486. Predict the Winner

// optimal strategy for a game.

class Solution {
    private int[][] dp;
    private int helper(int[] nums, int start, int last, int sum) {
        if(start> last) return 0;
        else if(dp[start][last]!= 0) return dp[start][last];
        else {
            dp[start][last]= Math.max(sum- helper(nums, start+1, last, sum- nums[start]), 
                                     sum- helper(nums, start, last-1, sum- nums[last]));
            
            return dp[start][last];
        }
    }
    
    public boolean PredictTheWinner(int[] nums) {
        dp= new int[nums.length][nums.length];
        int sum= 0;
        for(int i: nums)
            sum+= i;
        helper(nums, 0, nums.length-1, sum);
                
        return dp[0][nums.length-1]>= sum-dp[0][nums.length-1];
    }
}
