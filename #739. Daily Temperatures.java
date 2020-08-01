// #739. Daily Temperatures
// Prefer using an array as a stack just for efficiency purpose.

class Solution {
    public int[] dailyTemperatures(int[] T) 
    {
        Stack<Integer> stack=new Stack<>();
        int[] ans=new int[T.length];
        
        for(int i=T.length-1;i>=0;i--)
        {
            while(!stack.isEmpty() && T[stack.peek()]<=T[i])
                stack.pop();
            
            if(stack.isEmpty())
                ans[i]=0;
            else
                ans[i]= stack.peek()-i;
            stack.push(i);
        }
    
        return ans;
    }
}
