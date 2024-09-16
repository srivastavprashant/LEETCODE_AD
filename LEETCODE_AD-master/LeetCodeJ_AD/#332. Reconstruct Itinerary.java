package LeetCodeJ;// #332. Reconstruct Itinerary


/*Naive Approach did not knew about the eulerian trails.
  OBSERVATION:
    1. We need to traverse all the edges exactly once, we can traverse the vertex more than once.
    2. Every vertex may have one edge which when taken will lead to an disconnected graph or we can say we will end up before iterating through all the edges. 
  Approach : 
    So basically i have first converted the vertex from a string to number for the ease of understanding.
    Then i have created an adjacency list but as we need the lexicographically smallest eulerian trail so i have sorted all the vertex than can be visited from another vertex.
    
    But as mentioned in observations its not necessary that taking an edge with less value will lead to coverage of all edges so at every point we will make two 
    choice we can either go the vertex which has least value or to the vertex which has the second least value.
      Why? as only one edge can lead to an undercoverage thats why we just traverse the least 2 values instead.
 */



class Solution 
{
    List<String> ans;
    int n;
    List<String> sort;
    void call(List<List<Integer>> arr, int curr, List<String> path)
    {
        path.add(sort.get(curr));
        //System.out.println(path);
        if(arr.get(curr).size()== 0 || ans.size()== n)
        {
            if(ans.size()< path.size())
                ans= new ArrayList<>(path);
            return;
        }
        
        int val= arr.get(curr).get(arr.get(curr).size()-1);
        arr.get(curr).remove(arr.get(curr).size()-1);
        call(arr, val, path);
        path.remove(path.size()-1);
        arr.get(curr).add(val);
        
        if(arr.get(curr).size()>1)
        {
            int val2= arr.get(curr).get(arr.get(curr).size()-2);
            arr.get(curr).remove(arr.get(curr).size()-2);
            call(arr, val2, path);
            
            path.remove(path.size()-1);
            val= arr.get(curr).get(arr.get(curr).size()-1);
            arr.get(curr).remove(arr.get(curr).size()-1);
            arr.get(curr).add(val2);
            arr.get(curr).add(val);
        }   
    }
    
    public List<String> findItinerary(List<List<String>> tickets) 
    {
        n= tickets.size()+1;
        HashSet<String> set= new HashSet<>();
        for(List<String> i: tickets)
        { set.add(i.get(0)); set.add(i.get(1)); }
        sort= new ArrayList<>(set);
        Collections.sort(sort);
        
        HashMap<String, Integer> map= new HashMap<>();
        for(int i=0;i<sort.size();i++)
            map.put(sort.get(i), i);
        
        // create the adjacency list
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<sort.size();i++)
            adj.add(new ArrayList<>());
        
        for(List<String> i: tickets)
        {
            int from= map.get(i.get(0));
            int to= map.get(i.get(1));
            
            adj.get(from).add(to);
        }
        
        for(int i=0;i<adj.size();i++)
            Collections.sort(adj.get(i), Collections.reverseOrder());
        
        ans= new ArrayList<>();
        call(adj, map.get("JFK"), new ArrayList<>());
        
        return ans;
    }
}

/* 
  Other possibilities:
  1. Fleury's Algorithm: which basically uses a bridge detecting algorithm to find if we choose this edge will it lead to undercoverage or fomally speaking 
  if this edge is chosen will the graph get disconnected or not 
    So time complexity of this algorithm will be O(edges^2): as we traverse all the edges and while choosing each edge we check is this makes the grpah disconnected or 
    is this edge an bridge or not.
   
  2. Hierholzer's algorithm: //TODO
  */
