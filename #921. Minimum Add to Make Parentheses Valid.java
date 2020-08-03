// #921. Minimum Add to Make Parentheses Valid
class Solution {
    public int minAddToMakeValid(String S) 
    {
        int ans=0, count=0;
        int[] map=new int[]{1,-1};
        
        for(char c: S.toCharArray())
        {
            count+= map[c-40];
            
            if(count<0)
            {
                ans++;
                count=0;
            }
        }
        return ans+ count;
    }
}
