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

// Union by rank and path compression 
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
            
            if(rank[a]> rank[b])
                parent[b]= a;
            else if(rank[a]< rank[b])
                parent[a]= b;
            else
            { parent[b]= a; rank[a]++; }
        }
        
        boolean isConnected(int a, int b)
        {
            int tempA= a, tempB= b;
            while(parent[a]!= a)
                a= parent[a];
            
            while(parent[b]!= b)
                b= parent[b];
            
            while(parent[tempA]!= tempA)
            {
                int temp= tempA;
                tempA= parent[tempA];
                parent[temp]= a;
            }
            
            while(parent[tempB]!= tempB)
            {
                int temp= tempB;
                tempB= parent[tempB];
                parent[temp]= b;
            }
            
            return a== b;
        }
    }
}


// Approach 2: DFS+ memoization
class Solution 
{
    int[][][] memo;
    int[] ans;
    int n, m;
    
    int DFSREC(int[][] grid, int row, int col, boolean upper, boolean[][][] visited)
    {
        if(row== n) return col;
        else if(col<0 || col== m) return -1;
        else if(memo[row][col][upper?0:1]!= -1) return memo[row][col][upper?0:1];
        else if(visited[row][col][upper?0:1]) return -1;
        else
        {
            visited[row][col][upper?0:1]= true;
            int ans= -1;
            if(grid[row][col]== 1)
            {
                if(upper && col+1!= m)
                    ans= DFSREC(grid, row, col+1, grid[row][col+1]== -1, visited);
                else if(!upper)
                    ans= DFSREC(grid, row+1, col, true, visited);
            }
            else
            {
                if(upper && col-1 >-1)
                    ans= DFSREC(grid, row, col-1, grid[row][col-1]== 1, visited);
                else if(!upper)
                    ans= DFSREC(grid, row+1, col, true, visited);
            }
            
            memo[row][col][upper? 0: 1]= ans;
            visited[row][col][upper? 0: 1]= false;
            return ans;
        }
    }
    
    public int[] findBall(int[][] grid) 
    {
        n= grid.length;
        m= grid[0].length;
        memo= new int[n][m][2];
        ans= new int[m];
        for(int[][] i: memo)
            for(int[] j: i)
                Arrays.fill(j, -1);
        
        boolean[][][] visited= new boolean[n][m][2];
        for(int i=0;i<m;i++)
            ans[i]= DFSREC(grid, 0, i, true, visited);
        
        return ans;
    }
}
