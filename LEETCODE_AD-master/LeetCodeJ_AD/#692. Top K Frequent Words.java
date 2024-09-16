package LeetCodeJ;//692. Top K Frequent Words

class Solution {
    public List<String> topKFrequent(String[] words, int k) 
    {
        HashMap<String, Integer> map= new HashMap<>();
        for(String s: words)
            map.put(s, map.getOrDefault(s, 0)+1);
        
        ArrayList<String> key= new ArrayList<>(map.keySet());
        Comparator<String> comp= new Comparator<String>()
        {
            public int compare(String a, String b)
            {
                if(map.get(a)== map.get(b))
                    return a.compareTo(b);
                else
                    return map.get(b)- map.get(a);
            }
        };
            
        Collections.sort(key, comp);
        System.out.println(map);
        ArrayList<String> ans= new ArrayList<>();
        for(int i=0;i<k && i< key.size();i++)
            ans.add(key.get(i));
        
        return ans;
    }
}
