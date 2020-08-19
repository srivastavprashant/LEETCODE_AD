// 127. Word Ladder

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        char[][] word=new char[wordList.size()+1][];
        word[0]= beginWord.toCharArray();
        char[] destination= endWord.toCharArray();
        boolean[] seen=new boolean[word.length];
        seen[0]= true;
        
        for(int i=0;i<word.length-1;i++)
        {
            String s= wordList.get(i);
            word[i+1]= s.toCharArray();
        }
        
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        
        int len=1;
        while(!q.isEmpty())
        {
            int size= q.size();
            
            for(int ii=0;ii< size;ii++)
            {
                int curr= q.poll();
                if(match(word[curr], destination)==0)
                    return  len;
                
                for(int i=0;i<word.length;i++)
                {
                    if(seen[i]) continue;
                    
                    if(match(word[i], word[curr])==1)
                    { q.add(i); seen[i]= true; }
                }
            }
            len++;
        }
        return 0;
    }
    
    static int match(char[] a, char[] b)
    {
        int ret=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]!= b[i])
                ret++;
            
            if(ret>1) return ret;
        }
        return ret;   
    }
}
