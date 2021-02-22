// #1768. Merge Strings Alternately


class Solution {
    public String mergeAlternately(String word1, String word2) 
    {
        StringBuilder ans= new StringBuilder("");
        int i= 0;
        for(i=0;i<Math.min(word1.length(), word2.length());i++)
            ans.append(word1.charAt(i)+""+word2.charAt(i));
        
        if(word1.length()< word2.length())
        {
            for(int j=i;j<word2.length();j++)
                ans.append(word2.charAt(j));
        }
        else if(word1.length()> word2.length())
        {
            for(int j=i;j<word1.length();j++)
                ans.append(word1.charAt(j));
        }
        
        return ans.toString();
    }
}
