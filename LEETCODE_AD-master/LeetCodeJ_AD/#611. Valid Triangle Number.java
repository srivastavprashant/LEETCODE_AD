package LeetCodeJ;/*
  #611. Valid Triangle Number
*/

class Solution {
    public int triangleNumber(int[] nums) 
    {
        Arrays.sort(nums);
        int ans=0;
        
        for(int i=0;i<nums.length;i++)
        {
            for(int j= i+1;j<nums.length;j++)
            {
                int key= nums[i]+ nums[j]-1;
                int index= binary(nums, j+1, nums.length-1, key);
                
                ans+= index- j;
                //System.out.println(i+" "+j+" "+index+" "+ans);
            }
        }
        return ans;
    }
    
    static int binary(int[] nums, int start, int last, int key)
    {
        while(start<=last)
        {
            int mid= start+ (last- start)/2;
            if(nums[mid]<= key)
                start= mid+1;
            else
                last= mid-1;
        }
        return last;
    }
}
