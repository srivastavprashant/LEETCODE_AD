package LeetCodeJ;// #802. Find Eventual Safe States


class Solution 
{
    HashSet<Integer> cycle;
    boolean DFSREC(int[][] graph, boolean[] visited, HashSet<Integer> arr, int curr)
    {
        visited[curr]= true;
        arr.add(curr);
        
        for(int neighbour: graph[curr])
        {
            if(!visited[neighbour] && DFSREC(graph, visited, arr, neighbour))
                return true;
            else if(arr.contains(neighbour) || cycle.contains(neighbour))
            {
                cycle.addAll(arr);
                return true;
            }
        }
        
        arr.remove(curr);
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) 
    {
        cycle= new HashSet<>();
        boolean[] visited= new boolean[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            if(visited[i]) continue;
            
            DFSREC(graph, visited, new HashSet<>(), i);
        }
        
        ArrayList<Integer> ans= new ArrayList<>();
        for(int i=0;i<graph.length;i++)
            if(!cycle.contains(i))ans.add(i);
        
        return ans;
    }
}
