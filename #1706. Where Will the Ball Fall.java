// #1706. Where Will the Ball Fall


// Approach 1: Disjoint Set 
class Solution 
{
    int n, m;
    public int[] findBall(int[][] grid) 
    {
        n= grid.length;
        m= grid[0].length;
        
        DisjointSet dsu= new DisjointSet(n*m*2+ m*2+ 1);
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]== 1)
                {
                    //upper part will be connected to j+1
                    if(j!= grid[0].length-1)
                        dsu.union(getIndex(grid, i, j, true), getIndex(grid, i, j+1, grid[i][j+1]!=1));
                    
                    // lower part will be connected to i+1
                    dsu.union(getIndex(grid, i, j, false), getIndex(grid, i+1, j, true));
                }
                else
                {
                    //upper part will be connected to j-1
                    if(j!= 0)
                        dsu.union(getIndex(grid, i, j, true), getIndex(grid, i, j-1, grid[i][j-1]== 1));
                    
                    // lower part will be connected to 
                    dsu.union(getIndex(grid, i, j, false), getIndex(grid, i+1, j, true));
                }
            }
        }
        
        int[] ans= new int[m];
        Arrays.fill(ans, -1);
        for(int i=0;i<m;i++)
        {
            for(int j= 0;j<m;j++)
                if(dsu.isConnected(getIndex(grid, 0, i, true), getIndex(grid, n, j, true)))
                { ans[i]= j; break; }
        }
        
        return ans;
    }
    
    int getIndex(int[][] grid, int row, int col, boolean upper)
    {
        // System.out.println(row+" "+col+" "+upper+" "+ ((row*m+ col)*2+ (upper? 1: 2)));
        return (row*m+ col)*2+ (upper? 1: 2);
    }
    
    class DisjointSet
    {
        int[] parent;
        int[] rank;
        
        DisjointSet(int n)
        {
            // System.out.println(n);
            parent= new int[n];
            rank= new int[n];
            
            for(int i=0;i<n;i++)
                parent[i]= i;
        }
        
        void union(int a, int b)
        {
            while(parent[a]!= a)
                a= parent[a];
            
            while(parent[b]!= b)
                b= parent[b];
            
            parent[a]= b;
        }
        
        boolean isConnected(int a, int b)
        {
            while(parent[a]!= a)
                a= parent[a];
            
            while(parent[b]!= b)
                b= parent[b];
            
            return a== b;
        }
    }
}
