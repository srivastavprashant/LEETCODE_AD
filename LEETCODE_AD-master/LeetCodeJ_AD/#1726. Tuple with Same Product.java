package LeetCodeJ;// #1726. Tuple with Same Product



class Solution {
    public int tupleSameProduct(int[] nums) 
    {
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(i== j) continue;
                map.put(nums[i]*nums[j], map.getOrDefault(nums[i]*nums[j], 0)+1);
            }
        }
        
        int ans= 0;
        for(int i: map.keySet())
        {
            ans+= (map.get(i)*2)*(map.get(i)*2-2);
           // System.out.println("key=:"+i+" val="+map.get(i)+" "+(map.get(i)*2-2));
        }
                               
        
        return ans;
        
    }
}
