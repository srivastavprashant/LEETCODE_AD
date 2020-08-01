// 451. Sort Characters By Frequency
// Using inbuilt hashmap---------20ms.
class Solution {
    public String frequencySort(String s) 
    {
        HashMap<Character, Integer> map=new HashMap<>();
        for(char c: s.toCharArray())
            if(map.containsKey(c))
                map.put(c, map.get(c)+1);
            else
                map.put(c, 1);
        
        ArrayList<Character> arr=new ArrayList<>(map.keySet());
        
        Comparator<Character> comp=new Comparator<Character>()
        {
            public int compare(Character a, Character b)
            {
                return map.get(b)- map.get(a);
            }
        };
        
        Collections.sort(arr, comp);
        char[] ans=new char[s.length()];
        
        int i=0;
        for(char c: arr)
        {
            int freq= map.get(c);
            while(freq--!=0)
                ans[i++]= c;
        }
            
        return new String(ans);        
    }
}

// More Efficient version----- 5 ms beats 97%.
class Solution {
    public String frequencySort(String s) 
    {
        char[] map=new char[128];
        for(char c: s.toCharArray())
            map[c]++;
        
        ArrayList<Character> arr=new ArrayList<>(128);
        for(int i=0;i<128;i++)
            if(map[i]!=0)
                arr.add((char)i);
        
        Comparator<Character> comp=new Comparator<Character>()
        {
            public int compare(Character a, Character b)
            {
                return map[b]- map[a];
            }
        };
        
        Collections.sort(arr, comp);
        char[] ans=new char[s.length()];
        
        int i=0;
        for(char c: arr)
        {
            int freq= map[c];
            while(freq--!=0)
                ans[i++]= c;
        }
            
        return new String(ans);        
    }
}
