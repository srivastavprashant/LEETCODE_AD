// 851. Loud and Rich

class Solution 
{
    static int DFSREC(ArrayList<ArrayList<Integer>> list, boolean[] visited, int[] quiet, int[] ans, int curr)
    {
        visited[curr]= true;
        
        int ret= curr;
        for(int i: list.get(curr))
            if(!visited[i])
            {
                int temp= DFSREC(list, visited, quiet, ans, i);
                if(quiet[temp]<quiet[ret])
                    ret= temp;
            }
            else
            {
                int temp= ans[i];
                if(quiet[temp]<quiet[ret])
                    ret= temp;
            }
                
        
        ans[curr]= ret;
        return ret;
    }
    
    public int[] loudAndRich(int[][] richer, int[] quiet) 
    {
        // creating adjacency list
        ArrayList<ArrayList<Integer>> list= new ArrayList<>();
        for(int i=0;i<quiet.length;i++)
            list.add(new ArrayList<>());
        
        for(int[] edge: richer)
            list.get(edge[1]).add(edge[0]);
        
        // DFS traversal
        int[] ans= new int[quiet.length];
        Arrays.fill(ans, Integer.MAX_VALUE);
        boolean[] visited= new boolean[quiet.length];
        
        for(int i=0;i<quiet.length;i++)
        {
            if(visited[i]) continue;
            
            DFSREC(list, visited, quiet, ans, i);
        }
        
        return  ans;
    }
}
