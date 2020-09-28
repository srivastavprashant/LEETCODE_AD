// 1443. Minimum Time to Collect All Apples in a Tree

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) 
    {
        // creating an adjacency list
        ArrayList<ArrayList<Integer>> list= new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(new ArrayList<Integer>());
        
        for(int[] edge: edges)
        {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        
        // Calling DFS to calculate min Time. 
        boolean[] visited= new boolean[n];
        int time= DFSREC(list, visited, hasApple, 0);
        return time!=0? (time-1)*2: 0;
    }
    
    static int DFSREC(ArrayList<ArrayList<Integer>> list, boolean[] visited, List<Boolean> hasApple, int curr)
    {
        visited[curr]= true;
        
        int ret=0;
        for(int i: list.get(curr))
        {
            if(visited[i]) continue;
            
            ret+= DFSREC(list, visited, hasApple, i);
        }
        
        if(ret==0 && hasApple.get(curr))
            return 1;
        else if(ret!=0)
            return ret+1;
        else
            return 0;
    }
}
