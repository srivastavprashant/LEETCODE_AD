
// Approach 1: Depth first search.

class Solution 
{
    static boolean surrounded;
    static void DFSREC(char[][] board, boolean[][] visited, int row, int col)
    {
        visited[row][col]= true;
        
        if(row-1<0 || row+1>= board.length || col-1<0 || col+1>= board[0].length) surrounded= false;
        
        if(row-1>=0 && board[row-1][col]== 'O' && !visited[row-1][col])
            DFSREC(board, visited, row-1, col);
        
        if(row+1<board.length && board[row+1][col]== 'O' && !visited[row+1][col])
            DFSREC(board, visited, row+1, col);
        
        if(col-1>=0 && board[row][col-1]== 'O' && !visited[row][col-1])
            DFSREC(board, visited, row, col-1);
        
        if(col+1<board[0].length && board[row][col+1]== 'O' && !visited[row][col+1])
            DFSREC(board, visited, row, col+1);
        
    }
    public void solve(char[][] board) 
    {
        if(board.length== 0 || board[0].length==0) return;
        boolean[][] visited= new boolean[board.length][board[0].length];
        for(int i= 0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(visited[i][j] || board[i][j]== 'X') continue;
                boolean[][] visit= new boolean[visited.length][visited[0].length];
                surrounded= true;
                DFSREC(board, visit, i, j);
                
                if(surrounded)
                {
                    for(int ii=0;ii<board.length;ii++)
                        for(int jj=0;jj<board[0].length;jj++)
                            if(visit[ii][jj])
                                board[ii][jj]= 'X';
                }
                
                for(int ii=0;ii<board.length;ii++)
                    for(int jj=0;jj<board[0].length;jj++)
                        if(visit[ii][jj])
                            visited[ii][jj]= true;
            }
        }
    }
}

/*

[["X","O","X","O","X","O"],
 ["O","X","O","X","O","X"],
 ["X","O","X","O","X","O"],
 ["O","X","O","X","O","X"]]
*/
