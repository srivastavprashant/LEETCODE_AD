// 1642. Furthest Building You Can Reach


class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) 
    {
        int max=0, diff=0, i;
        for(i=0;i<heights.length-1;i++)
        {
            if(heights[i]< heights[i+1])
            {
                diff+= heights[i+1]- heights[i];
                max= Math.max(max, heights[i+1]- heights[i]);
            }
            
            if(diff> bricks)
            {
                if(ladders==0)
                    break;
                else
                {
                    diff-= max;
                    ladders--;
                }
            }
        }
        
        return i;
    }
}
