// 1717. Maximum Score From Removing Substrings



class Solution {
    public int maximumGain(String s, int x, int y) 
    {
        char[] arr;
        int ret= 0;
        if(x> y)
            arr= new char[]{'a', 'b'};
        else
            arr= new char[]{'b', 'a'};
        
        Stack<Character> stack= new Stack<>();
        for(char c: s.toCharArray())
        {
            if(stack.isEmpty())
                stack.push(c);
            else
            {
                if(stack.peek()== arr[0] && c== arr[1])
                {
                    ret+= Math.max(x, y);
                    stack.pop();
                }
                else
                    stack.push(c);
            }
        }
        
        StringBuilder br= new StringBuilder();
        while(!stack.isEmpty())
            br.append(stack.pop());
        
        s= br.reverse().toString();
        for(char c: s.toCharArray())
        {
            if(stack.isEmpty())
                stack.push(c);
            else
            {
                if(stack.peek()== arr[1] && c== arr[0])
                {
                    ret+= Math.min(x, y);
                    stack.pop();
                }
                else
                    stack.push(c);
            }
        }

        return ret;
    }
}
