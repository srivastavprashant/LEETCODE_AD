// #1519. Number of Nodes in the Sub-Tree With the Same Label



class Solution 
{
    static int[] ans;
    static int[] DFSREC(ArrayList<ArrayList<Integer>> arr, char[] label, int curr, int parent)
    {
        int[] ret= new int[26];
        ret[label[curr]- 'a']++;
        
        for(int i: arr.get(curr))
        {
            if(i== parent) continue;
            
            int[] child= DFSREC(arr, label, i, curr);
            for(int ii=0;ii<26;ii++)
                ret[ii]+= child[ii];
        }
        
        ans[curr]= ret[label[curr]-'a'];
        return ret;
    }
    
    public int[] countSubTrees(int n, int[][] edges, String labels) 
    {
        ArrayList<ArrayList<Integer>> arr= new ArrayList<>();
        for(int i=0;i<n;i++)
            arr.add(new ArrayList<>());
        
        for(int[] edge: edges)
        {
            arr.get(edge[0]).add(edge[1]);
            arr.get(edge[1]).add(edge[0]);
        }
        
        ans= new int[n];
        DFSREC(arr, labels.toCharArray(), 0, -1);
        return ans;
    }
}
