// 1144. Decrease Elements To Make Array Zigzag


class Solution 
{
    public int movesToMakeZigzag(int[] nums) 
    {
        int ans=0;
        int[] copy= new int[nums.length];
        for(int i=0;i<nums.length;i++)
            copy[i]= nums[i];
        
        for(int i=0;i<nums.length;i+=2)
        {
            int prev= (i-1>=0)?nums[i-1]: nums[i]-1;
            int next= (i+1< nums.length)? nums[i+1]: nums[i]-1;
            
            if(prev>=nums[i])
            { ans+= prev- nums[i]+1; }
            
            if(next>=nums[i])
            { ans+= next- nums[i]+1; nums[i+1]= nums[i]-1; }
        }
    
        int min_ans=ans;
        ans=0;
        nums= copy;
        for(int i=1;i<nums.length;i+=2)
        {
            int prev= (i-1>=0)?nums[i-1]: nums[i]-1;
            int next= (i+1< nums.length)? nums[i+1]: nums[i]-1;
            
            if(prev>=nums[i])
            { ans+= prev- nums[i]+1; }
            
            if(next>=nums[i])
            { ans+= next- nums[i]+1; nums[i+1]= nums[i]-1; }
        }
        
        return Math.min(min_ans, ans);
    }
}
