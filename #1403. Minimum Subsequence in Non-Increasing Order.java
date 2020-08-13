
class Solution {
    public List<Integer> minSubsequence(int[] nums) 
    {
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<nums.length;i++)
            sum+= nums[i];
        
        List<Integer> ans=new ArrayList<>();
        int curr_sum=0;
        for(int i=nums.length-1;i>=0;i--)
        {
            curr_sum+= nums[i];
            ans.add(nums[i]);
            if(curr_sum> sum- curr_sum)
                return ans;
        }
        return ans;        
    }
}
