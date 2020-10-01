// 554. Brick Wall

class Solution {
    public int leastBricks(List<List<Integer>> wall) 
    {
        HashMap<Integer, Integer> map=new HashMap<>();
        int pos=0;
        
        for(List<Integer> list: wall)
        {
            pos=0;
            for(int i: list)
                map.put(pos+=i, map.getOrDefault(pos, 0)+1);
        }
        
        int max= Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> i: map.entrySet())
            if(i.getKey()!= pos)
                max= Math.max(i.getValue(), max);
        
        return max>0? wall.size()-max: wall.size();
    }
}
