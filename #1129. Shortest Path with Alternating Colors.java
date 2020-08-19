// 1129. Shortest Path with Alternating Colors

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) 
    {
        Queue<Integer> node= new LinkedList<>();
        Queue<Integer> color=new LinkedList<>();
        int[] ans=new int[n];
        boolean[][] seen=new boolean[n][2];
        List<List<List<Integer>>> list=new ArrayList<>(n);
        Arrays.fill(ans, -1);
        seen[0][0]= true;
        seen[0][1]= true;
        
        for(int i=0;i<n;i++)
        {
            List<List<Integer>> temp=new ArrayList<>();
            temp.add(new ArrayList<Integer>());
            temp.add(new ArrayList<Integer>());
            list.add(temp);
        }
        
        for(int[] i: red_edges)     // 0= Red
            list.get(i[0]).get(0).add(i[1]);
        
        for(int[] i: blue_edges)       // 1= Blue
            list.get(i[0]).get(1).add(i[1]);
        
        node.add(0);
        color.add(2);
        int len=0;
        while(!node.isEmpty())
        {
            int size= node.size();
            
            for(int ii=0;ii<size;ii++)
            {
                int curr_node= node.poll();
                int curr_color= color.poll();
                if(ans[curr_node]==-1)
                    ans[curr_node]= len;
                
                for(int i=0;i<2;i++)
                {
                    if(curr_color== i) continue;
                    
                    List<Integer> temp= list.get(curr_node).get(i);
                    for(int j: temp)
                    { 
                        if(seen[j][i]) continue;
                        node.add(j);
                        color.add(i); 
                        seen[j][i]= true;
                    }
                }
            }
            len++;
        }
        return ans;       
        
    }
}
