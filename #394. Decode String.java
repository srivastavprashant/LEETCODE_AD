// 394. Decode String

class Solution {
    public String decodeString(String s) 
    {
        Stack<String> stack= new Stack<>();
        
        for(char c: s.toCharArray())
        {
            if(c== ']')
            {
                StringBuilder br= new StringBuilder("");
                while(stack.peek().charAt(0)!= 91)
                    br.append(stack.pop());
                
                stack.pop();
                
                int n=0, power=0;
                while(!stack.isEmpty() && stack.peek().charAt(0)>=48 && stack.peek().charAt(0)<= 57)
                    n+= (stack.pop().charAt(0)-48)* Math.pow(10, power++); 
                
                for(int i=0;i<n;i++)
                    stack.push(br.toString());
            }
            else
                stack.push(c+"");
        }
        
        StringBuilder ans= new StringBuilder("");
        while(!stack.isEmpty())
            ans.append(stack.pop());
        
        return ans.reverse().toString();        
    }
}
