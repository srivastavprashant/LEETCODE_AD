package LeetCodeJ;// #983. Minimum Cost For Tickets



class Solution 
{
    int[] memo;
    int call(int[] days, int[] costs, int curr_day)
    {
        if(curr_day> 365) return 0;
        if(days[curr_day]== 0)  return call(days, costs, curr_day+1);
        else if(memo[curr_day]!= -1) return memo[curr_day];
        else
        {
            int min= Integer.MAX_VALUE;
            min= Math.min(min, costs[0]+ call(days, costs, curr_day+1));
            min= Math.min(min, costs[1]+ call(days, costs, curr_day+7));
            min= Math.min(min, costs[2]+ call(days, costs, curr_day+30));
            
            memo[curr_day]= min;
            return min;
        }
    }
    public int mincostTickets(int[] days, int[] costs) {
        int[] map= new int[366];
        for(int i:days)
            map[i]++;
        
        memo= new int[366];
        Arrays.fill(memo, -1);
        return call(map, costs, 1);
    }
}
