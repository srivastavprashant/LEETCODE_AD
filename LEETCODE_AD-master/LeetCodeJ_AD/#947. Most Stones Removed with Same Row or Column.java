package LeetCodeJ;// #947. Most Stones Removed with Same Row or Column


class Solution 
{
    public int removeStones(int[][] stones) 
    {
        UnionFind dsu= new UnionFind(stones.length);
        HashMap<Integer, ArrayList<Integer>> x_axis= new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> y_axis= new HashMap<>();
        
        for(int index= 0;index< stones.length; index++)
        {
            int[] i= stones[index];
            if(x_axis.containsKey(i[0]))
                x_axis.get(i[0]).add(index);
            else
            {
                ArrayList<Integer> temp= new ArrayList<>();
                temp.add(index);
                
                x_axis.put(i[0], temp);
            }
            
            if(y_axis.containsKey(i[1]))
                y_axis.get(i[1]).add(index);
            else
            {
                ArrayList<Integer> temp= new ArrayList<>();
                temp.add(index);
                
                y_axis.put(i[1], temp);
            }
        }
        
        for(Map.Entry<Integer, ArrayList<Integer>> i: x_axis.entrySet())
        {
            ArrayList<Integer> temp= i.getValue();
            for(int j=1; j< i.getValue().size(); j++)
            {
                if(!dsu.isConnected(temp.get(j-1), temp.get(j)))
                    dsu.union(temp.get(j-1), temp.get(j));
            }
        }
        
        for(Map.Entry<Integer, ArrayList<Integer>> i: y_axis.entrySet())
        {
            ArrayList<Integer> temp= i.getValue();
            for(int j=1; j< temp.size(); j++)
            {
                if(!dsu.isConnected(temp.get(j-1), temp.get(j)))
                    dsu.union(temp.get(j-1), temp.get(j));
            }
        }
        
        return stones.length- dsu.largestGroup();
            
    }
}

class UnionFind
{
    int[] par, rank;
    UnionFind(int size)
    {
        par= new int[size];
        rank= new int[size];
        
        for(int i=0;i<size;i++)
            par[i]= i;
    }
    
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
            par[b]= a;
            rank[a]++;
        }
    }
    
    boolean isConnected(int a, int b)
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
    
    int parent(int a)
    {
        while(par[a]!= a)
            a= par[a];
        
        return a;
    }
    
    int largestGroup()
    {
        int ans= 0;
        for(int i=0;i<par.length;i++)
            if(par[i]== i)
                ans++;
        
        return ans;
    }
}

