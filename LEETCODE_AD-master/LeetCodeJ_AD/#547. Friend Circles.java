// 547. Friend Circles

Approach 1: Using depth first search.
class Solution 
{
    static void DFSREC(int[][] arr, boolean[] visited, int i)
    {
        visited[i]= true;
        
        for(int j=0;j<arr[i].length;j++)
            if(!visited[j] && arr[i][j]==1)
                DFSREC(arr, visited, j);
    }
    
    public int findCircleNum(int[][] M) 
    {
        boolean[] visited= new boolean[M.length];
        int ans=0;
        
        for(int i=0;i<M.length;i++)
        {
            if(!visited[i])
            {
                DFSREC(M, visited, i);
                ans++;
            }
        }
        return ans;
    }
}

Approach 2: Union find 
class Solution {
    public int findCircleNum(int[][] M) 
    {
        UnionFind dsu= new UnionFind(M.length);
        
        for(int i=0;i<M.length;i++)
        {
            for(int j=0;j<M[0].length;j++)
            {
                if(M[i][j]== 1)
                    dsu.union(i, j);
            }
        }
        
        return dsu.frndCircle();   
    }
}

class UnionFind
{
    int[] parent, rank;
    UnionFind(int size)
    {
        parent= new int[size];
        for(int i=0;i<size;i++)
            parent[i]= i;
        
        rank= new int[size];
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
        {
            parent[b]= a;
            rank[a]++;
        }
    }
    
    int frndCircle()
    {
        int ans= 0;
        for(int i=0;i<parent.length;i++)
            ans+= (parent[i]==i? 1: 0);
        
        return ans;
    }
}

