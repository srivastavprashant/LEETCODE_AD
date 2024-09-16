package LeetCodeJ;// #1695. Maximum Erasure Value


class Solution {
    public int maximumUniqueSubarray(int[] nums) 
    {
        int[] prefix= new int[nums.length];
        for(int i=0;i<nums.length;i++)
            prefix[i]= (i!=0? prefix[i-1]: 0)+ nums[i];
        
        HashMap<Integer, Integer> map= new HashMap<>();
        int start= 0, max= Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                int temp= map.get(nums[i])+1; 
                while(start!= temp)
                    map.remove(nums[start++]);
                
                start= temp;
                map.put(nums[i], i);
            }
            else
                map.put(nums[i], i);
            
            max= Math.max(prefix[i]- (start==0? 0: prefix[start-1]), max);
            //System.out.println(max+" "+start+" "+i);
        }
        
        return max;
    }
}
