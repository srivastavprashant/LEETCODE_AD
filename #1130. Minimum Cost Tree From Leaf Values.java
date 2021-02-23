// #1130. Minimum Cost Tree From Leaf Values



// Memoization
class Solution 
{
    int[][][] memo;
    int[] call(int[] arr, int start, int last)
    {
        if(memo[start][last][0]!= 0)
            return memo[start][last];
        if(start== last)
            return new int[]{arr[start], 0};
        else
        {
            int[] ret= new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
            for(int i=start;i< last;i++)
            {
                int[] left= call(arr, start, i);
                int[] right= call(arr, i+1, last);
                
                ret[0]= Math.max(left[0], right[0]);
                ret[1]= Math.min(ret[1], left[1]+ right[1]+ left[0]* right[0]);
            }
            
            memo[start][last]= ret;
            return ret;
        }
    }
    
    public int mctFromLeafValues(int[] arr) 
    {
        memo= new int[arr.length][arr.length][2];
        int[] ans= call(arr, 0, arr.length-1);
        
        return ans[1];
    }
}
