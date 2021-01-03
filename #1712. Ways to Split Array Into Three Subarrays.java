// #1712. Ways to Split Array Into Three Subarrays
// time complexity O(n*logn*logn)


class Solution {
    public int waysToSplit(int[] nums) 
    {
        int[] prefix= new int[nums.length];
        for(int i=0;i<nums.length;i++)
            prefix[i]+= (i!=0? prefix[i-1]: 0)+ nums[i];
        
        long ans= 0;
        for(int i=0;i<nums.length-2;i++)
        {
            int j= binaryMore(prefix, i+1, nums.length-1, prefix[i]*2);
            if(j== -1) continue;
            int k= binaryLess(prefix, j, nums.length-2, (prefix[nums.length-1]-prefix[i])/2+ prefix[i]);
            if(k== -1) continue;
            
            ans+= (k-j+1);
        }
        
        return (int)(ans%1000000007);
    }
    
    int binaryLess(int[] arr, int start, int last, int find)
    {
        int ret= -1;
        while(start<= last)
        {
            int mid= start+ (last- start)/2;
            
            if(arr[mid]<= find)
            {
                start= mid+1;
                ret= mid;
            }
            else
                last= mid-1;
        }
        
        return ret;
    }
    
    int binaryMore(int[] arr, int start, int last, int find)
    {
        int ret= -1;
        while(start<= last)
        {
            int mid= start+ (last- start)/2;
            
            if(arr[mid]>= find)
            {
                last= mid-1;
                ret= mid;
            }
            else
                start= mid+1;
        }
        
        return ret;
    }
}
