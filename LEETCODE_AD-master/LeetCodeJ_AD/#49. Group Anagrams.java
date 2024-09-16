package LeetCodeJ;// 49. Group Anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        List<List<String>> ans= new ArrayList<>();
        HashMap<String, ArrayList<String>> map=new HashMap<>();
        
        for(String s: strs)
        {
            int[] map1= new int[26];
            Arrays.fill(map1, -1);
            
            for(char c: s.toCharArray())
                map1[c-'a']++;
            
            StringBuilder br= new StringBuilder("");
            for(int i: map1)
                br.append(i+"");
            
            String key= br.toString();
            if(map.containsKey(key))
                map.get(key).add(s);
            else
                map.put(key, new ArrayList<>(Arrays.asList(s)));
        }
        
        for(Map.Entry<String, ArrayList<String>> i: map.entrySet())
            ans.add(i.getValue());
        
        return ans;
    }
}
