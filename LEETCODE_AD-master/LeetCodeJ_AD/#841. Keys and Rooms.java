package LeetCodeJ;// 841. Keys and Rooms

class Solution 
{
    static int count;
    static void DFSREC(List<List<Integer>> rooms, boolean[] visited, int j)
    {
        count++;
        visited[j]= true;
        
        for(int i: rooms.get(j))
        {
            if(!visited[i])
                DFSREC(rooms, visited, i);
        }
    }
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) 
    {
        boolean[] visited=new boolean[rooms.size()];
        count=1;
        visited[0]= true;
        
        for(int j: rooms.get(0))
        {
            if(!visited[j])
                DFSREC(rooms, visited, j);
        }
        
        return count== rooms.size();
    }
}
