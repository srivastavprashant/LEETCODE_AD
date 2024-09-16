package LeetCodeJ;// #1736. Latest Time by Replacing Hidden Digits

class Solution {
    public String maximumTime(String time) 
    {
        char[] ans= time.toCharArray();
        
        if(ans[0]== '?' && (ans[1]< '4' || ans[1]== '?'))
            ans[0]= '2';
        else if(ans[0]== '?')
            ans[0]= '1';
        
        if(ans[0]== '2')
        {
            if(ans[1]== '?')
                ans[1]= '3';
        }
        else
        {
            if(ans[1]== '?')
                ans[1]= '9';
        }
        
        if(ans[3]== '?')
            ans[3]= '5';
        
        if(ans[4]== '?')
            ans[4]= '9';
        
        return new String(ans);
        
    }
}
