// #792. Number of Matching Subsequences
class Solution {
    public int numMatchingSubseq(String S, String[] words) 
    {
        int[] len=new int[words.length];
        int[] index=new int[words.length];
                            
        char[][] word=new char[words.length][];
        int ans=0;
        
        for(int i=0;i<words.length;i++)
            word[i]= words[i].toCharArray();
        
        ArrayList<Integer>[] chars=new ArrayList[26];
        
        for(int i=0;i<26;i++)
            chars[i]= new ArrayList<>();
        
        for(int i=0;i<word.length;i++)
            chars[word[i][0]-'a'].add(i);
        
        for(int i=0;i<word.length;i++)
            len[i]= word[i].length;
        
        for(char ch: S.toCharArray())
        {
            ArrayList<Integer> arr=new ArrayList<>(chars[ch-'a']);
            chars[ch-'a'].clear();
            for(int i: arr)
            {
                //System.out.println(i+" "+chars[ch-'a']);
                index[i]++;
                if(index[i]== len[i])
                {
                    ans++;
                    continue;
                }
                chars[word[i][index[i]]-'a'].add(i);
                //System.out.println(chars[i]);
            }
        }
        return ans;
    }
}
