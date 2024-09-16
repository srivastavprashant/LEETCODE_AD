package LeetCodeJ;// #494. Target Sum


// recursive brute force
class Solution {
    private int helper(int[] nums, int target, int sum, int curr) {
        if(curr== nums.length) return target== sum? 1: 0;
        else {
            int ret= helper(nums, target, sum- nums[curr], curr+1);
            ret+= helper(nums, target, sum+ nums[curr], curr+1);
            
            return ret;
        }
    }
    
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, 0, 0);
    }
}

// memoization 
class Solution {
    private HashMap<Integer, Integer>[] dp;
    private int helper(int[] nums, int target, int sum, int curr) {
        if(curr== nums.length) return target== sum? 1: 0;
        else if(dp[curr].containsKey(sum)) return dp[curr].get(sum);
        else {
            int ret= helper(nums, target, sum- nums[curr], curr+1);
            ret+= helper(nums, target, sum+ nums[curr], curr+1);
            
            dp[curr].put(sum, ret);
            return ret;
        }
    }
    
    public int findTargetSumWays(int[] nums, int target) {
        dp= new HashMap[nums.length];
        for(int i=0;i<nums.length;i++)
            dp[i]= new HashMap<>();
        
        return helper(nums, target, 0, 0);
    }
}
