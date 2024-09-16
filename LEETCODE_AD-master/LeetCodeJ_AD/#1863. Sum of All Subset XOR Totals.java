package LeetCodeJ;

// Obvious Solution: O(2^n)

class Solution {
    int ans= 0;
    public int subsetXORSum(int[] nums) {
        helper(nums, 0, 0);
        return ans;
    }
    
    void helper(int[] nums, int index, int xor) {
        if(index== nums.length) ans+= xor;
        else {
            helper(nums, index+1, xor^nums[index]);
            helper(nums, index+1, xor);
        }
    }
}

// Efficient Solution: Contribution technique + combinatorics : O(n)

class Solution {
    public int subsetXORSum(int[] nums) {
        int val= 0;
        for(int i: nums) val|= i;
        
        return val*(1<<(nums.length-1));
    }
}

    
