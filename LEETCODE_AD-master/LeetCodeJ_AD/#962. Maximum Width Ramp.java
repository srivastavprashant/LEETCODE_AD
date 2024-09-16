package LeetCodeJ;// 962. Maximum Width Ramp

class Solution {
    public int maxWidthRamp(int[] A) 
    {
        int ans=0;
        for(int i=0;i<A.length;i++)
        {
            for(int j=A.length-1;j>= i+ans;j--)
            {
                if(A[i]<= A[j])
                {
                    ans= j-i;
                    break;
                }
            }
        }
        
        return ans;
    }
}
