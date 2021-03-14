// #1793. Maximum Score of a Good Subarray


class Solution 
{
    public int maximumScore(int[] nums, int k) 
    {
        int[] before= new int[nums.length];
        int[] after= new int[nums.length];
        findBefore(nums, before);
        findAfter(nums, after);
        
//         for(int i=0;i<nums.length;i++)
//             System.out.print(after[i]+" ");
//         System.out.println();
        
//         for(int i=0;i<nums.length;i++)
//             System.out.print(before[i]+" ");
//         System.out.println();
        
        int ans= Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(before[i]+1<= k && after[i]-1>= k)
                ans= Math.max(ans, nums[i]*(after[i]- before[i]-1));
        }
        
        return ans;
    }
    
    void findBefore(int[] nums, int[] before)
    {
        Stack<Integer> stack= new Stack<>();
        for(int i=0;i<nums.length;i++)
        {
            while(!stack.isEmpty() && nums[stack.peek()]>= nums[i])
                stack.pop();
            
            if(stack.isEmpty())
                before[i]= -1;
            else
                before[i]= stack.peek();
            
            stack.add(i);
        }
    }
    
    void findAfter(int[] nums, int[] before)
    {
        Stack<Integer> stack= new Stack<>();
        for(int i=nums.length-1;i>=0;i--)
        {
            while(!stack.isEmpty() && nums[stack.peek()]>= nums[i])
                stack.pop();
            
            if(stack.isEmpty())
                before[i]= nums.length;
            else
                before[i]= stack.peek();
            
            stack.add(i);
        }
    }
}
