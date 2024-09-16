package LeetCodeJ;/*
  Approach: It is a brain teaser as it does'nt matters whether ants meet or not. We can think about this like given position and length tell when it will fall.
            O( N ) time and O( 1 ) space complexity.
*/

class Solution {
    public int getLastMoment(int n, int[] left, int[] right) 
    {
        int ans=0;
        
        for(int i=0;i<left.length;i++)
            ans= Math.max(ans, left[i]);
        for(int i=0;i<right.length;i++)
            ans= Math.max(ans, n-right[i]);
        return ans;
    }
}
