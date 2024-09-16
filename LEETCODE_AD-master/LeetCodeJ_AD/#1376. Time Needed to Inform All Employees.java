package LeetCodeJ;

// 1376. Time Needed to Inform All Employees
class Solution 
{
    static int max_time=0;
    static void DFSREC(ArrayList<ArrayList<Integer>> list, int[] informTime, int id, int time)
    {
        for(int i: list.get(id))
            DFSREC(list, informTime, i, time+informTime[id]);
        
        max_time= Math.max(max_time, time);
    }
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) 
    {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        
        for(int i=0;i<n;i++)
            list.add(new ArrayList<Integer>());
        
        for(int i=0;i<manager.length;i++)
            if(manager[i]!=-1) list.get(manager[i]).add(i);
        
        max_time=0;
        DFSREC(list, informTime, headID, 0);
        
        return max_time;
    }
}
