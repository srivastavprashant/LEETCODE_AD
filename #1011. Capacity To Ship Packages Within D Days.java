// 1011. Capacity To Ship Packages Within D Days

class Solution 
{
    static boolean check(int max, int[] arr, int d)
    {
        int sum=0, days=0;
        for(int i=0;i<arr.length;i++)
            if(sum+ arr[i]> max)
            { sum= arr[i]; days++; }
            else
                sum+= arr[i];
        
        if(sum>0) days++;
        
        if(days<= d)
            return true;
        else
            return false;
    }
    
    public int shipWithinDays(int[] weights, int D) 
    {
        int sum=0, min_ans= 0;
        for(int i=0;i<weights.length;i++)
        {
            sum+= weights[i];
            min_ans= Math.max(weights[i], min_ans);
        }
        
        int start= min_ans, last= sum, prev=0, mid=0;
        while(start<= last)
        {
            mid= start+ (last- start)/2;
        
            if(!check(mid, weights, D))
                start= mid+1;
            else
            { last= mid-1; prev= mid; }
        }
        
        return prev;
    }
}
