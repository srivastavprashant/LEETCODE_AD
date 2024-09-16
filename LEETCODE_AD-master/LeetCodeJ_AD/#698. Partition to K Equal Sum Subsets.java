package LeetCodeJ;// #698. Partition to K Equal Sum Subsets



class Solution {
    private boolean helper(int[] nums, int[] subsets, int curr, int sum) {
        if(curr== nums.length) return true;
        else {
            boolean ret= false;
            for(int i=0;i<subsets.length;i++) {
                if(subsets[i]+ nums[curr]<= sum) {
                    subsets[i]+= nums[curr];
                    
                    if(helper(nums, subsets, curr+1, sum)) return true;
                    subsets[i]-= nums[curr];
                }
            }
                        
            return ret;
        }
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int[] subsets= new int[k];
        int sum= 0;
        for(int i: nums) sum+= i;
        if(sum%k!= 0) return false;
        
        return helper(nums, subsets, 0, sum/k);
    }
}
