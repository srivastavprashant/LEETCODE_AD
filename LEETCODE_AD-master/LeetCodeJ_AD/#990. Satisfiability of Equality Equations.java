package LeetCodeJ;// #990. Satisfiability of Equality Equations



class Solution {
    public boolean equationsPossible(String[] equations) 
    {
        UnionFind dsu= new UnionFind(26);
        ArrayList<Integer[]> check= new ArrayList<>();
        for(String eq: equations)
        {
            if(eq.charAt(1)== '=')
                dsu.union(eq.charAt(0)-'a', eq.charAt(3)-'a');
            else
                check.add(new Integer[]{eq.charAt(0)-'a', eq.charAt(3)-'a'});
        }
        
        for(Integer[] i: check)
            if(dsu.isConnected(i[0], i[1]))
                return false;
        
        return true;        
    }
}

class UnionFind
{
    int[] par, rank;
    UnionFind(int size)
    {
        rank= new int[size];
        par= new int[size];
        for(int i=0;i<size;i++)
            par[i]= i;
    }
    
    // union by rank
    
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
    
    // path compression 
    boolean isConnected(int a, int b)
    {
        int tempA= a, tempB= b;
        while(par[a]!= a)
            a= par[a];
        
        while(par[b]!= b)
            b= par[b];
        
        while(par[tempA]!= tempA)
        {
            int temp= par[tempA];
            tempA= par[tempA];
            par[temp]= a;
        }
        
        while(par[tempB]!= tempB)
        {
            int temp= par[tempB];
            tempB= par[tempB];
            par[temp]= b;
        }
        
        return a== b;
    }
}
