// #207. Course Schedule


class Solution 
{
    static boolean DFSREC(ArrayList<ArrayList<Integer>> arr, boolean[] visited, int curr, HashSet<Integer> set)
    {
        set.add(curr);
        visited[curr]= true;
        
        for(int i: arr.get(curr))
        {
            if(!visited[i] && DFSREC(arr, visited, i, set)) 
                return true;
            else if(set.contains(i))
                return true;
        }
        set.remove(curr);
        
        return false;
    }   
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        ArrayList<ArrayList<Integer>> graph= new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            graph.add(new ArrayList<>());
        
        for(int[] i: prerequisites)
            graph.get(i[0]).add(i[1]);
        
        boolean[] visited= new boolean[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            if(visited[i]) continue;
            if(DFSREC(graph, visited, i, new HashSet<>()))
                return false;
        }
        
        return true;
    }
}

/*
    We just need to tell whether its possible or not to watch all the course in right order.
    so basically its a cycle finding problem in directed graph, as until we have a cycle we can watch the 
    course in right order.
        (can be easily done using DFS)
    
    If it was given to find the right order to watch it then we could have implemented 
    topological sorting.
*/
