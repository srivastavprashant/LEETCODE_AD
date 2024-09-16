package LeetCodeJ;// #377. Combination Sum IV


class Solution {
    private int[] dp;
    private int helper(int[] arr, int target) {
        if(dp[target]!= -1) return dp[target];
        else {
            int ret= 0;
            for(int i=0;i<arr.length;i++) {
                if(arr[i]<= target)
                ret+= helper(arr, target- arr[i]);
            }
            
            dp[target]= ret;
            return ret;
        }
    }
    
    public int combinationSum4(int[] nums, int target) {
        dp= new int[target+1];
        Arrays.fill(dp, -1);
        dp[0]= 1;
        return helper(nums, target);
    }
}
