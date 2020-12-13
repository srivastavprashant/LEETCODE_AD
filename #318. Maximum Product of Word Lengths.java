// #318. Maximum Product of Word Lengths



class Solution {
    public int maxProduct(String[] words) 
    {
        int[] map= new int[words.length];
        for(int i=0;i<map.length;i++)
        {
            int decimal= 0;
            for(char c: words[i].toCharArray())
                decimal|= (1<<(c-48));
            
            map[i]= decimal;
        }
        
        int max= 0;
        for(int i=0;i<map.length;i++)
        {
            for(int j=0;j< map.length;j++)
            {
                if((map[i]&map[j])== 0)
                    max= Math.max(words[i].length()* words[j].length(), max);
            }
        }
        
        return max;
    }
}
