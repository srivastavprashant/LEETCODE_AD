// #684. Redundant Connection



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
