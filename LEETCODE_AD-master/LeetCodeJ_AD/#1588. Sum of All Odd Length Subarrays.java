package LeetCodeJ;// 1588. Sum of All Odd Length Subarrays

class Solution 
{
    public int sumOddLengthSubarrays(int[] arr) 
    {
        int ans=0;
        for(int i=1;i<arr.length;i++)
            arr[i]+= arr[i-1];
        
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i;j<arr.length;j+=2)
                ans+= arr[j]- (i!=0? arr[i-1]: 0);
        }
        
        return ans;
    }
}
