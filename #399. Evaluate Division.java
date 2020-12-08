#399. Evaluate Division


class Solution 
{
    static double cost;
    static void DFSREC(ArrayList<ArrayList<Double[]>> adj, boolean[] visited, int curr, int find, double value)
    {
        visited[curr]= true;
        if(curr== find)
            cost= value;
        
        for(Double[] arr: adj.get(curr))
        {
            if(visited[arr[0].intValue()]) continue;
            
            DFSREC(adj, visited, arr[0].intValue(), find, value* arr[1]);
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) 
    {
        // convert the variables to number. 
        int c= 0;
        HashMap<String, Integer> map= new HashMap<>();
        for(List<String> i: equations)
        {
            if(!map.containsKey(i.get(0)))
                map.put(i.get(0), c++);
            if(!map.containsKey(i.get(1)))
                map.put(i.get(1), c++);
        }
        c= 0;
        
        // create adjacency list representation of the graph.
        ArrayList<ArrayList<Double[]>> adj= new ArrayList<>();
        for(int i=0;i<map.size();i++)
            adj.add(new ArrayList<>());
        
        for(int i=0;i<values.length;i++)
        {
            List<String> eq= equations.get(i);
            int a= map.get(eq.get(0));
            int b= map.get(eq.get(1));
            
            adj.get(a).add(new Double[]{1.0*b, values[i]});
            adj.get(b).add(new Double[]{1.0*a, 1/values[i]});
        }
        
        // find the value for each query using dfs
        double[] ans= new double[queries.size()];
        for(List<String> eq: queries)
        {
            int a= map.getOrDefault(eq.get(0), -1);
            int b= map.getOrDefault(eq.get(1), -1);
            
            if(a== -1 || b== -1)
                ans[c++]= -1.0;
            else
            {
                cost= -1.0;
                boolean[] visited= new boolean[adj.size()];
                DFSREC(adj, visited, a, b, 1.0);
                
                ans[c++]= cost;
            }
        }
        
        return ans;
    }
}
