package LeetCodeJ;// #856. Score of Parentheses


class Solution {
    public int scoreOfParentheses(String S) 
    {
        Stack<Integer> stack= new Stack<>();
        for(char c: S.toCharArray())
        {
            if(c== '(')
                stack.push(-1);
            else
            {
                int val= 0;
                while(stack.peek()!= -1)
                    val+= stack.pop();
                
                stack.pop();
                if(val== 0) stack.push(1);
                else stack.push(val*2);
            }
        }
        
        int ans= 0;
        while(!stack.isEmpty())
            ans+= stack.pop();
        
        return ans;
    }
}
