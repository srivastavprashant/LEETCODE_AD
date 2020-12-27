// #1631. Path With Minimum Effort



class Solution 
{
    public int minimumEffortPath(int[][] heights) 
    {
        int ans= 1000000;
        int start= 0, last= 1000000;
        while(start<= last)
        {
            int mid= start+ (last- start)/2;
            boolean[][] visited= new boolean[heights.length][heights[0].length];
            
            if(possible(heights, 0, 0, mid, visited, heights[0][0]))
            {
                //System.out.println(mid);
                ans= mid;
                last= mid-1;
            }
            else
                start= mid+1;
        }
        
        return ans;
    }
    
    boolean possible(int[][] heights, int row,  int col, int cost, boolean[][] visited, int curr_cost)
    {
        // check if this row and col is valid and not visited.
        if(row<0 || col<0 || row>= heights.length || col>= heights[0].length || visited[row][col])
            return false;
        
        // check if the cost of taking this path is below our threshold or not.
        if(Math.abs(curr_cost- heights[row][col])> cost)
            return false;
        
        // check if we have reached the destination or not
        if(row== heights.length-1 && col== heights[0].length-1)
            return true;
        
        // add the node to the visited list
        visited[row][col]= true;
        
        // iterate through all the paths possible from this node.
        boolean found= possible(heights, row+1, col, cost, visited, heights[row][col]);
        found|= possible(heights, row-1, col, cost, visited, heights[row][col]);
        found|= possible(heights, row, col+1, cost, visited, heights[row][col]);
        found|= possible(heights, row, col-1, cost, visited, heights[row][col]);
        
        return found;
    }
}

// predicate function: binary search
