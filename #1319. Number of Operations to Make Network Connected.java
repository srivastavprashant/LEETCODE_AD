// 1319. Number of Operations to Make Network Connected

class Solution 
{
    static int cable;
    static void DFSREC(ArrayList<ArrayList<Integer>> list, boolean[] visited, int curr, int parent)
    {
        visited[curr]= true;
        
        for(int i: list.get(curr))
        {
            if(visited[i] && i!= parent)
            { cable++; continue; }
            else if(!visited[i])
                DFSREC(list, visited, i, curr);            
        }
    }
    
    public int makeConnected(int n, int[][] connections) 
    {
        // creating adjacency list
        ArrayList<ArrayList<Integer>> list= new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(new ArrayList<Integer>());
        
        for(int[] edge: connections)
        {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        
        // DFS traversal
        boolean[] visited= new boolean[n];
        int cable_required=0;
        cable=0;
        for(int i=0;i<n;i++)
        {
            if(visited[i]) continue;
            
            DFSREC(list, visited, i, -1);
            cable_required++;
        }
        
        cable= cable/2;
        cable_required-= 1; 
        
        if(cable>= cable_required)
            return cable_required;
        else
            return -1;
    }
}
