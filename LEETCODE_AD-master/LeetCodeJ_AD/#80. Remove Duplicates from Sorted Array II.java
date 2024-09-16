package LeetCodeJ;// 80. Remove Duplicates from Sorted Array II


class Solution {
    public int removeDuplicates(int[] nums) 
    {
        int val=0, count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!= val)
            { count=1; val= nums[i]; }
            else
                count++;
            
            if(count>2)
                nums[i]= 100000;
        }
        
        int i=0, j=0;
        for(;i<nums.length;i++, j++)
        {
            while(i< nums.length && nums[i]== 100000)
            { i++; }
            
            if(i== nums.length)
                break;
            
            if(i!= j)
                nums[j]= nums[i];
        }
        
        return j;
    }
}
