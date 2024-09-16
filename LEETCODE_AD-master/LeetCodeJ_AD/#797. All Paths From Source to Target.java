package LeetCodeJ;// #797. All Paths From Source to Target



class Solution 
{
    static List<List<Integer>> list;
    static void DFSREC(int[][] graph, List<Integer> arr, int curr)
    {
        arr.add(curr);
        if(curr== graph.length-1)  
            list.add(new ArrayList<>(arr));
        
        for(int i: graph[curr])
            DFSREC(graph, arr, i);
        
        arr.remove(arr.size()-1);
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) 
    {
        list= new ArrayList<>();
        DFSREC(graph, new ArrayList<>(), 0);
        
        return list;
    }
}
