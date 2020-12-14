// #1544. Make The String Great


class Solution {
    public String makeGood(String s) 
    {
        Stack<Integer> stack= new Stack<>();
        for(char c: s.toCharArray())
        {
            if(stack.isEmpty())
                stack.push(c+0);
            else
            {
                int i= stack.peek();
                if(i+32== c || i-32== c)
                    stack.pop();
                else
                    stack.push(c+0);
            }
        }
        
        char[] ans= new char[stack.size()];
        int count= stack.size()-1;
        while(!stack.isEmpty())
            ans[count--]= (char)stack.pop().intValue();
        
        return new String(ans);
    }
}
