#934. Shortest Bridge



class Solution 
{
    static void DFSREC(int[][] arr, int row, int col)
    {
        arr[row][col]= 3;
        
        if(row-1>=0 && arr[row-1][col]== 1)
            DFSREC(arr, row-1, col);
        
        if(row+1<arr.length && arr[row+1][col]== 1)
            DFSREC(arr, row+1, col);
        
        if(col-1>=0 && arr[row][col-1]== 1)
            DFSREC(arr, row, col-1);
        
        if(col+1< arr[0].length && arr[row][col+1]== 1)
            DFSREC(arr, row, col+1);
    }
    
    public int shortestBridge(int[][] A) 
    {
        outer:for(int i=0;i<A.length;i++)
            for(int j=0;j<A[0].length;j++)
                if(A[i][j]== 1) { DFSREC(A, i, j); break outer; }
        
        Queue<Integer[]> q= new LinkedList<>();
        for(int i=0;i<A.length;i++)
            for(int j=0;j<A[0].length;j++)
                if(A[i][j]== 3)
                    q.add(new Integer[]{i, j});
        
        int bridges= 0;
        while(!q.isEmpty())
        {
            int size= q.size();
            for(int i=0;i<size;i++)
            {
                Integer[] curr= q.poll();
                int row= curr[0];
                int col= curr[1];
                
                if(row-1>=0 && A[row-1][col]!= 3)
                { q.add(new Integer[]{row-1, col}); if(A[row-1][col]==1) return bridges; A[row-1][col]= 3; }
        
                if(row+1<A.length && A[row+1][col]!= 3)
                { q.add(new Integer[]{row+1, col}); if(A[row+1][col]==1) return bridges; A[row+1][col]= 3; }
        
                if(col-1>=0 && A[row][col-1]!= 3)
                { q.add(new Integer[]{row, col-1}); if(A[row][col-1]==1) return bridges; A[row][col-1]= 3; }
        
                if(col+1< A[0].length && A[row][col+1]!= 3)
                { q.add(new Integer[]{row, col+1}); if(A[row][col+1]==1) return bridges; A[row][col+1]= 3; }
            }
            
            bridges++;
        }
        return -1;
    }
}
