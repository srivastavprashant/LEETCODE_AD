package LeetCodeJ;// #721. Accounts Merge



class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) 
    {
        // assigning a number to every email as we will be making a disjoint set.
        // names will be lost so assigning name with every email.
        int c= 0;
        HashMap<String, Integer> map= new HashMap<>();
        HashMap<String, String> name= new HashMap<>();
        for(List<String> acc: accounts)
        {
            String person= acc.get(0);
            for(int i=1;i<acc.size();i++)
            {
                String s= acc.get(i);
                if(!map.containsKey(s))
                    map.put(s, c++);
                
                name.put(s, person);
            }
        }
        c= 0;
        
        // grouping all the emails, using union operation of union find.
        UnionFind dsu= new UnionFind(map.size());
        for(List<String> acc: accounts)
            for(int i= 2;i<acc.size();i++)
                dsu.union(map.get(acc.get(i-1)), map.get(acc.get(i)));
        
        // retrieving the groups and storing them together.
        HashMap<Integer, ArrayList<String>> group= new HashMap<>();
        for(String s: map.keySet())
        {
            int val= dsu.find(map.get(s));
            if(group.containsKey(val))
                group.get(val).add(s);
            else
            {
                ArrayList<String> arr= new ArrayList<>();
                arr.add(s);
                group.put(val, arr);
            }
        }
        
        // sorting the emails list and assigning a name associated with it.
        List<List<String>> ans= new ArrayList<>();
        for(Map.Entry<Integer, ArrayList<String>> i: group.entrySet())
        {
            List<String> temp= i.getValue();
            Collections.sort(temp);
            temp.add(0, name.get(temp.get(0)));
            ans.add(temp);
        }
        
        return ans;
    }
}

class UnionFind
{
    int[] par;
    int[] rank;
    UnionFind(int size)
    {
        rank= new int[size];
        par= new int[size];
        
        for(int i=0;i<size;i++)
            par[i]= i;
    }
    
    // union by rank method used to optimize the union.
    void union(int a, int b)
    {
        while(par[a]!= a)
            a= par[a];
        
        while(par[b]!= b)
            b= par[b];
        
        if(rank[a]> rank[b])
            par[b]= a;
        else if(rank[b]> rank[a])
            par[a]= b;
        else
        {
            rank[a]++;
            par[b]= a;
        }
    }
    
    // path compression method used to optimize the find function.
    int find(int a)
    {
        int tempA= a;
        
        while(par[a]!= a)
            a= par[a];
        
        while(par[tempA]!= tempA)
        {
            int temp= tempA;
            tempA= par[tempA];
            par[temp]= a;
        }
        
        return a;
    }
}
