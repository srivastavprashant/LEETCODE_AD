package LeetCodeJ;/*
  Approach: So, we know the water contained by a container will be max when the distance between then will be more along with the height.
            lets call distance between container as width. Water= height* width
            
            Observation: height of a container is min of both the height which make the container.
            Now, best candidate to store max water will be with max width i.e i=0 and j= height.length-1.
            But there can be a case when a container with less width be the ans as it has greater height.
            So, from above we can conclude that as the width gets smaller and smaller only way that we can get ans from smaller width is if we iterate towards increasing height.
            As less width along with less height wont take us to any ans.
*/

class Solution {
    public int maxArea(int[] height) 
    {
        int width= height.length-1;
        
        int i= 0, j= width, ans= Integer.MIN_VALUE;
        while(i<j)
        {
            int min= Math.min(height[i], height[j]);
            ans= Math.max(width*min, ans);
            
            min= height[i]>height[j]? j--: i++;
            width--;
        }
        return ans;
    }
}
