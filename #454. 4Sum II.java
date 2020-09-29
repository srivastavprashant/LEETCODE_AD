// 454. 4Sum II

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) 
    {
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i: A)
            for(int j: B)
                map.put(i+j, map.getOrDefault(i+j, 0)+1);
        
        int ans=0;
        for(int i: C)
            for(int j: D)
                if(map.containsKey(-i-j))
                    ans+= map.get(-i-j);
        
        return ans;        
    }
}
