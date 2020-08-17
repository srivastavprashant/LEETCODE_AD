// 1190. Reverse Substrings Between Each Pair of Parentheses

class Solution {
    public String reverseParentheses(String s) 
    {
        char[] arr= s.toCharArray();
        int parenthesis_count=0, count=0;
        Stack<Integer> stack= new Stack<>();
        
        for(int i=0;i<arr.length;i++)
        {
            char c= arr[i];
            
            if(c=='(')
            { parenthesis_count++; stack.push(i); }
            else if(c==')')
            { parenthesis_count++; reverse(arr, stack.pop(), i); }
        }
        
        char[] ans= new char[arr.length- parenthesis_count];
        for(int i=0;i<arr.length;i++)
            if(arr[i]!='(' && arr[i]!=')')
                ans[count++]= arr[i];
        
        return new String(ans);
    }
    
    static void reverse(char[] arr, int start, int last)
    {
        while(start< last)
        {
            arr[start]= (char) (arr[start]^ arr[last]);
            arr[last]=  (char) (arr[start]^ arr[last]);
            arr[start]= (char) (arr[start++]^ arr[last--]);
        }
    }
}
