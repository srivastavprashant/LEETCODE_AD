// #1685. Sum of Absolute Differences in a Sorted Array



class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) 
    {
        int sum= 0;
        for(int i: nums)
            sum+= i;
        
        int[] ans= new int[nums.length];
        int sumb= 0;
        for(int i=0;i<nums.length;i++)
        {
            ans[i]= sum- nums[i]* (nums.length-i);
            ans[i]+= nums[i]*i- sumb;
            
            sum-= nums[i];
            sumb+= nums[i];
        }
        
        return ans;
    }
}
