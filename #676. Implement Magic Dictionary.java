// 676. Implement Magic Dictionary

class MagicDictionary 
{
    HashMap<Integer, ArrayList<String>> map;
    public MagicDictionary() {
        map= new HashMap<>();
    }
    
    public void buildDict(String[] dictionary) 
    {
        for(String s: dictionary)
        {
            int len= s.length();
            
            if(map.containsKey(len))
                map.get(len).add(s);
            else
                map.put(len, new ArrayList<>(Arrays.asList(s)));
        }
    }
    
    public boolean search(String searchWord) 
    {
        int error=0;
        char[] search= searchWord.toCharArray();
        
        for(String s: map.getOrDefault(searchWord.length(), new ArrayList<>()))
        {
            error=0;
            char[] ch= s.toCharArray();
            for(int i=0;i<ch.length && error<2;i++)
                if(search[i]!= ch[i])
                    error++;
            
            if(error==1)
                return true;
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
