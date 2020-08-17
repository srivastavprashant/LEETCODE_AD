// 1249. Minimum Remove to Make Valid Parentheses

class Solution {
    public String minRemoveToMakeValid(String s) 
    {
        char[] arr= s.toCharArray();
        char[] ans=new char[arr.length];
        
        int val=0;
        int count=0;
        for(char c: arr)
        {
            if(c=='(')
                val++;
            else if(c==')' && val>0)
                val--;
            else if(c==')' && val==0)
                continue;
            ans[count++]= c;
        }
        
        for(int i=count-1;i>=0 && val!=0;i--)
            if(ans[i]=='(')
            {
                ans[i]=' ';
                val--;
            }
        
        StringBuilder br=new StringBuilder("");
        for(int i=0;i<count;i++)
            if(ans[i]!=' ')
                br.append(ans[i]);
        
        return br.toString();
    }
}
