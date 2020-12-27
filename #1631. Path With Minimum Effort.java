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

class Solution 
{
    public int minimumEffortPath(int[][] heights) 
    {
        //System.out.println(heights.length+" "+heights[0].length);
        int[][] visited= new int[heights.length][heights[0].length];
        for(int[] i: visited)
            Arrays.fill(i, Integer.MAX_VALUE);
        
        visited[0][0]= 0;
        int cost= 0;
        while(visited[heights.length-1][heights[0].length-1]>0)
        {
            int min= Integer.MAX_VALUE, row= -1, col= -1;
            for(int i=0;i<visited.length;i++)
            {
                for(int j=0;j<visited[0].length;j++)
                    if(visited[i][j]>=0 && min> visited[i][j])
                    {
                        row= i;
                        col= j;
                        min= visited[i][j];
                    }
            }
            
            //System.out.println(row+" "+col+" "+min);
            cost= Math.max(cost, min);
            if(row+1< heights.length && visited[row+1][col]>=0) 
                visited[row+1][col]= Math.min(visited[row+1][col], Math.abs(heights[row][col]- heights[row+1][col]));
            
            if(row-1>-1 && visited[row-1][col]>=0)
                visited[row-1][col]= Math.min(visited[row-1][col], Math.abs(heights[row][col]- heights[row-1][col]));
            
            if(col+1< heights[0].length && visited[row][col+1]>=0)
                visited[row][col+1]= Math.min(visited[row][col+1], Math.abs(heights[row][col]- heights[row][col+1]));
            
            if(col-1>-1 && visited[row][col-1]>=0)
                visited[row][col-1]= Math.min(visited[row][col-1], Math.abs(heights[row][col]- heights[row][col-1]));
            
            visited[row][col]= -1;
        }
        
        return cost;
    }
}

// dijkstra's algorithm: without priorityQueue.


class Solution 
{
    int cos= 0, r= 1, c= 2;
    public int minimumEffortPath(int[][] heights) 
    {
        int[][] cost= new int[heights.length][heights[0].length];
        PriorityQueue<int[]> q= new PriorityQueue<>((int[] a, int[] b) -> (a[cos]- b[cos]));
        for(int i=0;i<heights.length;i++)
        {
            for(int j=0;j<heights[0].length;j++)
            {
                if(i+j ==0) 
                    q.add(new int[]{0, 0, 0});
                else    
                {
                    q.add(new int[]{Integer.MAX_VALUE, i, j});
                    cost[i][j]= Integer.MAX_VALUE;
                }
            }
        }
        
        int ans= 0;
        while(true)
        {
            int[] candidate= new int[]{Integer.MAX_VALUE, -1, -1};
            while(true){
                candidate= q.poll();
                if(candidate[cos]== cost[candidate[r]][candidate[c]])
                    break;
            }
            
            int row= candidate[r];
            int col= candidate[c];
            ans= Math.max(ans, candidate[cos]);
            if(row== heights.length-1 && col== heights[0].length-1) break;
            
            if(row+1< heights.length && cost[row+1][col]> Math.abs(heights[row][col]- heights[row+1][col]))
            {
                cost[row+1][col]= Math.abs(heights[row][col]- heights[row+1][col]);
                q.add(new int[]{cost[row+1][col], row+1, col});
            }
            
            if(row-1>-1 && cost[row-1][col]> Math.abs(heights[row][col]- heights[row-1][col]))
            {
                cost[row-1][col]= Math.abs(heights[row][col]- heights[row-1][col]);
                q.add(new int[]{cost[row-1][col], row-1, col});
            }
            
            if(col+1< heights[0].length && cost[row][col+1]> Math.abs(heights[row][col]- heights[row][col+1]))
            {
                cost[row][col+1]= Math.abs(heights[row][col+1]- heights[row][col]);
                q.add(new int[]{cost[row][col+1], row, col+1});
            }
            
            if(col-1>-1 && cost[row][col-1]> Math.abs(heights[row][col]- heights[row][col-1]))
            {
                cost[row][col-1]= Math.abs(heights[row][col-1]- heights[row][col]);
                q.add(new int[]{cost[row][col-1], row, col-1});
            }
        }
        
        return ans;
    }
}

// dijkstra's algorithm with priority queue with lazy deletion.
