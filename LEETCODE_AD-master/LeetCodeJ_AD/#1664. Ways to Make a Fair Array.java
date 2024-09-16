package LeetCodeJ;// #1664. Ways to Make a Fair Array



class Solution 
{
    public int waysToMakeFair(int[] nums) 
    {
        int[] after0= new int[nums.length];
        int[] after1= new int[nums.length];
        int[] before0= new int[nums.length];
        int[] before1= new int[nums.length];
        
        int even= 0, odd= 0;
        for(int i=0;i<nums.length;i++)
        {
            before0[i]= even;
            before1[i]= odd;
            if((i&1)== 0) even+= nums[i];
            else odd+= nums[i];
        }
        
        even= 0; odd= 0;
        for(int i= nums.length-1; i>= 0; i--)
        {
            after0[i]= even;
            after1[i]= odd;
            if((i&1)== 0) even+= nums[i];
            else odd+= nums[i];        
        }
        
        int ans= 0;
        for(int i=0;i<nums.length;i++)
        {
            if(before0[i]+ after1[i]== before1[i]+ after0[i])
                ans++;
        }
        
        return ans;
    }
}
