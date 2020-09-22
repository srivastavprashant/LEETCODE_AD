// 1466. Reorder Routes to Make All Paths Lead to the City Zero

class Solution 
{
    static int ans;
    static void DFSREC(ArrayList<ArrayList<Integer>> list, HashSet<Integer>[] set, int curr, boolean[] visited)
    {
        visited[curr]= true;
        
        for(int i: list.get(curr))
        {
            if(visited[i]) continue;
            
            if(set[curr].contains(i))
                ans++;
            
            DFSREC(list, set, i, visited);
        }
    }
    
    public int minReorder(int n, int[][] connections) 
    {
        ArrayList<ArrayList<Integer>> list= new ArrayList<>();
        HashSet<Integer>[] set= new HashSet[n];
        ans=0;
        
        for(int i=0;i<n;i++)
        {
            list.add(new ArrayList<>());
            set[i]= new HashSet<>();
        }
        
        for(int[] i: connections)
        {
            list.get(i[0]).add(i[1]);
            set[i[0]].add(i[1]);
            list.get(i[1]).add(i[0]);
        }
        
        DFSREC(list, set, 0, new boolean[n]);
        return ans;
    }
}
