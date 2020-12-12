// #785. Is Graph Bipartite?


class Solution 
{
    public boolean isBipartite(int[][] graph) 
    {
        int[] color= new int[graph.length];
        Queue<Integer> q= new LinkedList<>();
        
        for(int i=0;i<color.length;i++)
        {
            if(color[i]!= 0) continue;
            q.add(i);
            color[i]= 1;
            
            while(!q.isEmpty())
            {
                int size= q.size();
                
                for(int ii=0;ii<size;ii++)
                {
                    int curr= q.poll();
                    
                    for(int j: graph[curr])
                    {
                        if(color[j]== color[curr]) return false;
                        else if(color[j]== 0)
                        {
                            color[j]= color[curr]* -1;
                            q.add(j);
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
