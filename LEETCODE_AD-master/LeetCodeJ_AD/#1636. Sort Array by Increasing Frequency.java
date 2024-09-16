package LeetCodeJ;// 1636. Sort Array by Increasing Frequency


class Solution {
    public int[] frequencySort(int[] nums) 
    {
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        
        Comparator<Integer> comp= new Comparator<Integer>()
        {
            @Override
            public int compare(Integer a, Integer b)
            {
                if(map.get(a)== map.get(b))
                    return b-a;
                else
                    return map.get(a)-map.get(b);
            }
        };
        
        ArrayList<Integer> arr= new ArrayList<>(map.keySet());
        Collections.sort(arr, comp);
        
        int[] ans= new int[nums.length];
        int c=0;
        for(int i=0;i<arr.size();i++)
        {
            for(int j=0;j<map.get(arr.get(i));j++)
                ans[c++]= arr.get(i);
        }
        
        return ans;
    }
}
