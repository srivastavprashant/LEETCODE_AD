package LeetCodeJ;// 795. Number of Subarrays with Bounded Maximum


class Solution {
    public int numSubarrayBoundedMax(int[] arr, int L, int R) 
    {
        int ans=0;
        
        for(int i=0;i<arr.length;i++)
        {
            int max=0;
            for(int j=i;j<arr.length;j++)
            {
                max= Math.max(max, arr[j]);
                
                if(max>=L && max<= R)
                    ans++;
                else if(max> R)
                    break;
            }
        }
        return ans;
    }
}
