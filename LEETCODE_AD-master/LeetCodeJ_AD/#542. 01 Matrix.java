package LeetCodeJ;// #542. 01 Matrix



class Solution {
    public int[][] updateMatrix(int[][] matrix) 
    {
        boolean[][] visited= new boolean[matrix.length][matrix[0].length];
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++)
                if(matrix[i][j]== 0)
                { q.add(i); q.add(j); visited[i][j]= true; }
        
        int time= 0;
        int[][] ans= new int[matrix.length][matrix[0].length];
        while(!q.isEmpty())
        {
            int size= q.size();
            for(int ii=0;ii<size/2;ii++)
            {
                int row= q.poll();
                int col= q.poll();
                ans[row][col]= time;
                
                if(row-1>=0 && !visited[row-1][col] && matrix[row-1][col]!= 0)
                { visited[row-1][col]= true; q.add(row-1); q.add(col); }
                
                if(row+1<matrix.length && !visited[row+1][col] && matrix[row+1][col]!=0)
                { visited[row+1][col]= true; q.add(row+1); q.add(col); }
                
                if(col-1>=0 && !visited[row][col-1] && matrix[row][col-1]!=0)
                { visited[row][col-1]= true; q.add(row); q.add(col-1); }
                
                if(col+1<matrix[0].length && !visited[row][col+1] && matrix[row][col+1]!=0)
                { visited[row][col+1]= true; q.add(row); q.add(col+1); }
            }
            //System.out.println(q);
            time++;
        }
        
        return ans;
    }
}
