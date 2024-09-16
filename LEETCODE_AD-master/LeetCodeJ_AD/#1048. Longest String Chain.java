package LeetCodeJ;// #1048. Longest String Chain



class Solution {
    public int longestStrChain(String[] words) 
    {
        TreeMap<Integer, HashMap<String, Integer>> map= new TreeMap<>();
        for(String s: words)
        {
            int len= s.length();
            if(map.containsKey(len))
                map.get(len).put(s, 0);
            else
            {
                map.put(len, new HashMap<>());
                map.get(len).put(s, 0);
            }
        }
        
        int max= 0;
        for(int ii: map.keySet())
        {
            for(String s: map.get(ii).keySet())
            {
                int len= s.length(), ans= 0;
                for(int i=0;i<len;i++)
                {
                    String find= s.substring(0, i)+ s.substring(i+1, len);
                    if(map.containsKey(len-1) && map.get(len-1).containsKey(find))
                        ans= Math.max(ans, map.get(len-1).get(find));
                }
                map.get(ii).put(s, 1+ans);
                max= Math.max(max, 1+ans);
            }
        }
        
        return max;
    }
}
