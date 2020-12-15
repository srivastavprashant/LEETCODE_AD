// #210. Course Schedule II



class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        int[] ans= new int[numCourses];
        int[] indegree= new int[numCourses];
        ArrayList<ArrayList<Integer>> graph= new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            graph.add(new ArrayList<>());
        
        for(int[] i: prerequisites)
        {
            indegree[i[1]]++;
            graph.get(i[0]).add(i[1]);
        }
        
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<indegree.length;i++)
            if(indegree[i]== 0)
            { q.add(i); indegree[i]= -1; }
        
        int count= ans.length-1;
        while(!q.isEmpty())
        {
            int size= q.size();
            for(int ii=0;ii<size;ii++)
            {
                int curr= q.poll();
                ans[count--]= curr;
                
                for(int i: graph.get(curr))
                    indegree[i]--;
                
                for(int i=0;i<numCourses;i++)
                    if(indegree[i]== 0)
                    { q.add(i); indegree[i]= -1; }
            }
        }
        
        if(count!= -1) return new int[]{};
        return ans;
    }
}

// Topological sorting.
