// #1743. Restore the Array From Adjacent Pairs


class Solution {
    public int[] restoreArray(int[][] adjacentPairs) 
    {
        HashMap<Integer, List<Integer>> map= new HashMap<>();
        for(int[] i: adjacentPairs)
        {
            if(map.containsKey(i[0]))
               map.get(i[0]).add(i[1]);
            else
               map.put(i[0], new ArrayList<>(Arrays.asList(i[1])));
               
            if(map.containsKey(i[1]))
               map.get(i[1]).add(i[0]);
            else
               map.put(i[1], new ArrayList<>(Arrays.asList(i[0])));
        }
               
        int val= -1;       
        for(int i: map.keySet())
        {
            if(map.get(i).size()== 1)
            {
                val= i;
                break;
            }
        }
               
        int[] ans= new int[adjacentPairs.length+1];
        HashSet<Integer> set= new HashSet<>();
        for(int i=0;i<ans.length;i++)
        {
            ans[i]= val;
            set.add(val);
            
            for(int j: map.get(val))
                if(!set.contains(j))
                {
                    val= j;
                    break;
                }
        }
        
        return ans;
    }
}
