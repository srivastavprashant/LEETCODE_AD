// #890: Find and replace pattern
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) 
    {
        HashSet<Integer> seen=new HashSet<>();
        int[][] map= new int[words.length][128];
        boolean[] bool=new boolean[words.length];
        char[] word= pattern.toCharArray();
        
        for(int i=0;i<word.length;i++)
        {
            int ch= word[i];
            
            for(int j=0;j<words.length;j++)
            {
                if(bool[j])
                    continue;
                else
                {
                    if(seen.contains(ch) && map[j][words[j].charAt(i)]!=ch)
                        bool[j]= true;
                    else if(!seen.contains(ch))
                    {
                        if(map[j][words[j].charAt(i)]!=0)
                            bool[j]= true;
                        else
                            map[j][words[j].charAt(i)]= ch;
                    }
                }
            }
        
            seen.add(ch);
        }
        List<String> ans=new ArrayList<>();
        for(int i=0;i<words.length;i++)
            if(!bool[i])
                ans.add(words[i]);
            
        return ans;
    }
}
