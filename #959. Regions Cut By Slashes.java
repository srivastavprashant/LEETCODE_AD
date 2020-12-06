#959. Regions Cut By Slashes


Approach: (Depth first search) 
    
class Solution 
{
    static void DFSREC(char[][] grid, boolean[][][] visited, int row, int col, int type)
    {
        visited[row][col][type]= true;
        
        // within the same row and col
        for(int i=0;i<4;i++)
        {
            if(visited[row][col][i] || type== i || type== (i+2)%4)
                continue;
            
            if(grid[row][col]== '/' && ((type== 2 && i== 3) || (type== 1 && i== 0) || (type== 3 && i== 2) || (type== 0 && i== 1))) continue;
               
            if(grid[row][col]== '\\' && ((type== 2 && i== 1) || (type== 1 && i== 2) || (type== 3 && i== 0) || (type== 0 && i== 3))) continue;
                
            
            DFSREC(grid, visited, row, col, i);
        }
        
        // outside the cell
        if(type== 0)
            if(row-1>-1 && !visited[row-1][col][2])
                DFSREC(grid, visited, row-1, col, 2);
        
        if(type== 1)
            if(col+1< grid[0].length && !visited[row][col+1][3])
                DFSREC(grid, visited, row, col+1, 3);
        
        if(type== 2)
            if(row+1< grid.length && !visited[row+1][col][0])
                DFSREC(grid, visited, row+1, col, 0);
        
        if(type== 3)
            if(col-1> -1 && !visited[row][col-1][1])
                DFSREC(grid, visited, row, col-1, 1);
    }

    public int regionsBySlashes(String[] _grid)
    {
        boolean[][][] visited= new boolean[_grid.length][_grid[0].length()][4];
        char[][] grid= new char[_grid.length][];
        
        for(int i=0;i<_grid.length;i++)
            grid[i]= _grid[i].toCharArray();
        
        int regions= 0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                for(int type= 0;type<4;type++)
                {
                    if(visited[i][j][type]) continue;
                    DFSREC(grid, visited, i, j, type);
                    regions++;
                }
            }
        }
        
        return regions;
    }
}

Approach 2: Union find 
Intuition: we need to find the number of regions or we can say number of different disjoint sets
Union by rank is used to make the code more optimized.
class DSU
{
    int[] par;
    int[] rank;
    DSU(int size)
    {
        par= new int[size];
        for(int i=0;i<size;i++)
            par[i]= i;
        
        rank= new int[size]; 
    }
    public void union(int a, int b)
    {
        while(par[a]!= a)
            a= par[a];
            
        while(par[b]!= b)
            b= par[b];
            
        if(rank[a]> rank[b])
            par[b]= a;
        else if(rank[a]< rank[b])
            par[a]= b;
        else
        { par[b]= a; rank[a]++; }
    }

    public int find(int x) {
        if (par[x] != x) par[x] = find(par[x]);
        return par[x];
    }
}
class Solution {
    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        DSU dsu = new DSU(4 * N * N);
        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c) {
                int root = 4 * (r * N + c);
                char val = grid[r].charAt(c);
                if (val != '\\') {
                    dsu.union(root + 0, root + 1);
                    dsu.union(root + 2, root + 3);
                }
                if (val != '/') {
                    dsu.union(root + 0, root + 2);
                    dsu.union(root + 1, root + 3);
                }

                // north south
                if (r + 1 < N)
                    dsu.union(root + 3, (root + 4 * N) + 0);
                if (r - 1 >= 0)
                    dsu.union(root + 0, (root - 4 * N) + 3);
                // east west
                if (c + 1 < N)
                    dsu.union(root + 2, (root + 4) + 1);
                if (c - 1 >= 0)
                    dsu.union(root + 1, (root - 4) + 2);
            }

        int ans = 0;
        for (int x = 0; x < 4 * N * N; ++x) {
            if (dsu.find(x) == x)
                ans++;
        }

        return ans;
    }
}
