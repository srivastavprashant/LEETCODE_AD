package LeetCodeJ;// #1722. Minimize Hamming Distance After Swap Operations


class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) 
    {
        UnionFind o= new UnionFind(source.length); 
        for(int[] i: allowedSwaps)
            o.union(i[0], i[1]);
        
        HashMap<Integer, HashSet<Integer>> map= new HashMap<>();
        for(int i=0;i<target.length;i++)
        {
            if(map.containsKey(target[i]))
                map.get(target[i]).add(i);
            else
                map.put(target[i], new HashSet<>(Arrays.asList(i)));
        }
        
        HashSet<Integer> seen= new HashSet<>();
        int ret= 0;
        for(int i=0;i<source.length;i++)
        {
            if(seen.contains(i)) continue;
            HashSet<Integer> index= map.getOrDefault(source[i], new HashSet<>());
            for(int j: index)
            {
                if(o.isConnected(i, j))
                {
                    index.remove(j);
                    ret--;
                    break;
                }
            }
            ret++;
        }
        
        return ret;
    }
}

class UnionFind
{
    int[] par;
    int[] rank;
    UnionFind(int n)
    {
        par= new int[n];
        rank= new int[n];
        for(int i=0;i<n;i++)
            par[i]= i;
    }
    
    public void union(int a, int b)
    {
        while(par[a]!= a)
            a= par[a];
            
        while(par[b]!= b)
            b= par[b];
            
        if(rank[a]> rank[b])
            par[b]= a;
        else if(rank[a]< rank[b])
            par[a]= b;
        else
        { par[b]= a; rank[a]++; }
    }

    public Boolean isConnected(int a, int b)
    {
        int tempA= a, tempB= b;
        while(par[a]!= a)
            a= par[a];
            
        while(par[tempA]!= tempA)
        {
            int temp= tempA;
            tempA= par[tempA];
            par[temp]= a;
        }
            
        while(par[b]!= b)
            b= par[b];
            
        while(par[tempB]!= tempB)
        {
            int temp= tempB;
            tempB= par[tempB];
            par[temp]= b;
        }
            
        if(b==a)
            return true;
        else
            return false;
    }
}
