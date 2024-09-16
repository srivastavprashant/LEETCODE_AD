package LeetCodeJ;// 16. 3Sum Closest


class Solution 
{
    public int threeSumClosest(int[] nums, int target) 
    {
        Arrays.sort(nums);
        int ans= Integer.MAX_VALUE, ret= 10000000;
        for(int i=0;i<nums.length;i++)
        {
            int sum= target- nums[i];
            
            int start=0, last= nums.length-1;
            while(start< last)
            {
                if(start== i) {start++; continue; }
                if(last== i) {last--; continue; }
                
                if(Math.abs(sum- nums[start]- nums[last])< ans)
                { ans= Math.abs(sum- nums[start]- nums[last]); ret= nums[i]+ nums[start]+ nums[last]; }
                
                //System.out.println(ret);
                
                if(nums[start]+ nums[last]== sum)
                    return target;
                else if(nums[start]+ nums[last]> sum)
                    last--;
                else 
                    start++;
            }
        }
        
        return ret;
    }
}
