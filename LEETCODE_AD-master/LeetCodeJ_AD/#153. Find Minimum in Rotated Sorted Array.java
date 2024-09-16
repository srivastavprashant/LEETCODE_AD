package LeetCodeJ;// 153. Find Minimum in Rotated Sorted Array


class Solution {
    public int findMin(int[] nums) 
    {
        int start= 0, last= nums.length-1;
        while(start+1< last)
        {
            int mid= start+ (last- start)/2;
            
            if(nums[mid]> nums[last])
                start= mid;
            else 
                last= mid;
            //System.out.println(start+" "+last);

        }
        
        return Math.min(nums[start], nums[last]);
    }
}
