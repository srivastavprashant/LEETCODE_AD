package LeetCodeJ;// #310. Minimum Height Trees


// Basically if we start traversing from the leaf node i.e in an undirected graph nodes with degree 1. 
// we will reach the middle of the tree in the end, which when rooted will give us our desired MHT's.
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) 
    {
        if(edges.length== 0)
            return new ArrayList<>(Arrays.asList(0));
        int[] degree= new int[n];
        ArrayList<ArrayList<Integer>> arr= new ArrayList<>();
        for(int i=0;i<n;i++)
            arr.add(new ArrayList<>());
        
        for(int[] edge: edges)
        {
            arr.get(edge[0]).add(edge[1]);
            arr.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<n;i++)
            if(degree[i]== 1) { q.add(i); degree[i]--; }
        
        ArrayList<Integer> ans= new ArrayList<>();
        while(!q.isEmpty())
        {
            int size= q.size();
            ans= new ArrayList<>();
            
            for(int ii=0;ii<size;ii++)
            {
                int curr= q.poll();
                ans.add(curr);
                
                for(int i: arr.get(curr))
                {
                    degree[i]--;
                    if(degree[i]== 1) q.add(i);
                }
            }
        }
            
        return ans;
    }
}
