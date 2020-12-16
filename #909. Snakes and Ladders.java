// #909. Snakes and Ladders



class Solution {
    public int snakesAndLadders(int[][] board) 
    {
        int n= board.length, dst= n*n-1;
        boolean[] visited= new boolean[n*n];
        Queue<Integer> q= new LinkedList<>();
        q.add(0);
        visited[0]= true;
        
        int steps= 0;
        while(!q.isEmpty())
        {
            int size= q.size();
            for(int i=0;i<size;i++)
            {
                int curr= q.poll();
                if(curr== dst)
                    return steps;
                
                for(int j=1;j<7;j++)
                {
                    if(curr+j>= n*n) continue;
                    int row= row(curr+j, n);
                    int col= col(curr+j, n);
                    if(board[row][col]!= -1 && !visited[board[row][col]-1])
                    {
                        visited[board[row][col]-1]= true;
                        q.add(board[row][col]-1);
                    }
                    else if(board[row][col]== -1 && !visited[curr+j])
                    {
                        q.add(curr+j);
                        visited[curr+j]= true;
                    }
                }
            }
        
            steps++;
        }
        
        return -1;
    }
    
    static int row(int start, int n)
    { return n-1- start/n; }
    static int col(int start, int n)
    { return (n-row(start, n))%2!=0? start%n: n- start%n-1; }
}
