// #1668. Maximum Repeating Substring



class Solution {
    public int maxRepeating(String sequence, String word) 
    {
        int k=0, ans=0;
        for(int i=0;i<=sequence.length()- word.length();i++)
        {
            int j;
            for(j=0;j<word.length();j++)
            {
                if(word.charAt(j)!= sequence.charAt(i+j))
                    break;
            }
            
            if(j== word.length())
            {
                k++;
                i= i+j-1;
            }
            else
                k=0;
            
            ans= Math.max(ans, k);
        }
        
        return ans;
    }
}
