package LeetCodeJ;// #886. Possible Bipartition



class Solution 
{
    int blue= 1, red= 2, not_defined= 0;
    public boolean possibleBipartition(int n, int[][] dislikes) 
    {
        ArrayList<ArrayList<Integer>> arr= new ArrayList<>();
        for(int i=0;i<=n;i++)
            arr.add(new ArrayList<>());
        
        for(int[] edge: dislikes)
        { arr.get(edge[0]).add(edge[1]); arr.get(edge[1]).add(edge[0]); }
        
        int[] color= new int[n+1];
        for(int i=1;i<=n;i++)
        {
            if(color[i]!= not_defined) continue;
            Queue<Integer> q= new LinkedList<>();
            q.add(i);
            color[i]= blue;
            
            while(!q.isEmpty())
            {
                int size= q.size();
                for(int ii=0;ii<size;ii++)
                {
                    int curr= q.poll();
                    
                    for(int j: arr.get(curr))
                    {
                        if(color[j]!= not_defined && color[j]== color[curr])
                            return false;
                        else if(color[j]!= not_defined)
                            continue;
                        color[j]= (blue== color[curr]? red: blue);
                        q.add(j);
                    }
                }
            }
        }
        
        return true;
    }
}
