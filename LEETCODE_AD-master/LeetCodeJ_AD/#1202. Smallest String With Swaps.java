package LeetCodeJ;// 1202. Smallest String With Swaps


class Solution 
{
    static int[] parent;
    static int[] rank;
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) 
    {
        int n= s.length();
        parent= new int[n];
        rank= new int[n];
        
        for(int i=0;i<n;i++)
            parent[i]= i;
        
        for(List<Integer> i: pairs)
            union(i.get(0), i.get(1));
        
        HashMap<Integer, ArrayList<ArrayList<Integer>>> map= new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int key= find(i);
            
            if(map.containsKey(key))
            {
                ArrayList<ArrayList<Integer>> temp= map.get(key);
                temp.get(0).add(i);
                temp.get(1).add(s.charAt(i)+0);
            }
            else
            {
                ArrayList<ArrayList<Integer>> temp= new ArrayList<>();
                temp.add(new ArrayList<>());
                temp.add(new ArrayList<>());
                temp.get(0).add(i);
                temp.get(1).add(s.charAt(i)+0);
                map.put(key, temp);
            }
        }
        
        char[] ans= new char[n];
        for(Map.Entry<Integer, ArrayList<ArrayList<Integer>>> i: map.entrySet())
        {
            ArrayList<Integer> index= i.getValue().get(0);
            ArrayList<Integer> value= i.getValue().get(1);
            Collections.sort(value);
            
            for(int j=0;j<value.size();j++)
                ans[index.get(j)]= (char) (value.get(j)+0);
        }
        
        return new String(ans);
    }
    
    static void union(int a, int b)
    {
        while(parent[a]!= a)
            a= parent[a];
        
        while(parent[b]!= b)
            b= parent[b];
        
        if(rank[a]== rank[b])
        { parent[a]= b; rank[b]++; }
        else if(rank[a]> rank[b])
            parent[b]= a;
        else
            parent[a]= b; 
    }
    
    static int find(int a)
    {
        while(parent[a]!= a)
            a= parent[a];
        
        return a;
    }
    
}
