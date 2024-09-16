package LeetCodeJ;// #684. Redundant Connection

/**
So, we have a graph which is basically a tree and one additional edge has been added to it.
    And obviously if an additional edges was added then it would have resulted in a cycle.
    
    Now we are asked to return the edge that caused that cycle or that redundant edge which destroyed the properties of tree.
    So, the very basic thing which comes in mind is to find that cycle i.e. find all the nodes involved in cycle 
    and then maybe we can iterate through the whole edges array given to us and find the edges which joins the nodes of the cycle.
    
    Depth first search implementation 
    time complexity : O(edges+ nodes) or the complexity of the dfs. Though linear but lets try the union find technique too.
*/

class Solution 
{
    static HashSet<Integer> cycle;
    static void DFSREC(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int curr, ArrayList<Integer> arr, int parent)
    {
        visited[curr]= true;
        arr.add(curr);
        
        for(int i: adj.get(curr))
        {
            if(parent== i) continue;
            
            if(visited[i])
            {
                boolean cycle_started= false;
                for(int j: arr)
                {
                    if(j== i)
                        cycle_started= true;
                    
                    if(cycle_started)
                        cycle.add(j);
                }
                continue;
            }
            
            DFSREC(adj, visited, i, arr, curr);
        }
        
        arr.remove(arr.size()-1);
    }
    
    public int[] findRedundantConnection(int[][] edges) 
    {
        int n= edges.length;
        // build the graph
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<=n;i++)
            adj.add(new ArrayList<>());
        
        for(int[] i: edges)
        {
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        
        // do a dfs and find the cycle
        boolean[] visited= new boolean[n+1];
        cycle= new HashSet<>();
        DFSREC(adj, visited, 1, new ArrayList<>(), -1);
        
        // iterate thorugh the edges and find the last edges that can be removed to make it a tree.
        for(int i=n-1;i>=0;i--)
            if(cycle.contains(edges[i][0]) && cycle.contains(edges[i][1]))
                return edges[i];
        
        return new int[]{};        
    }
}

// Approach 2: Union find 
class Solution 
{
    public int[] findRedundantConnection(int[][] edges) 
    {
        UnionFind dsu= new UnionFind(edges.length+1);
        
        for(int[] i: edges)
        {
            if(dsu.isConnected(i[0], i[1])) return i;
            
            dsu.union(i[0], i[1]);
        }
        
        return new int[]{};        
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
        
        // union by rank
        if(rank[a]> rank[b])
            par[b]= a;
        else if(rank[a]< rank[b])
            par[a]= b;
        else 
        {
            par[b]= a;
            rank[a]++;
        }
    }
    
    boolean isConnected(int a, int b)
    {
        while(par[a]!= a)
            a= par[a];
        
        while(par[b]!= b)
            b= par[b];
        
        return a==b;
    }
}
