// 347. Top K Frequent Elements

class Solution {
    public int[] topKFrequent(int[] nums, int k) 
    {
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i: nums)
            map.put(i, map.getOrDefault(i, 0)+1);
        
        ArrayList<Integer> arr= new ArrayList<>(map.keySet());
        Comparator<Integer> comp= new Comparator<Integer>()
        {
            public int compare(Integer a, Integer b)
            {
                return  map.get(b)- map.get(a);
            }
        };
        
        Collections.sort(arr, comp);
        int[] ans= new int[k];
        for(int i=0;i<k;i++)
            ans[i]= arr.get(i);
        
        return ans;
    }
}
