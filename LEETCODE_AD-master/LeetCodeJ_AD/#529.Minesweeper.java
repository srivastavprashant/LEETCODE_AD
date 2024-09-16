package LeetCodeJ;// Minesweeper

class Solution {
    public char[][] updateBoard(char[][] board, int[] click) 
    {
        if(board[click[0]][click[1]]=='M')
        {
            board[click[0]][click[1]]= 'X';
            return board;
        }
        
        boolean[][] visited=new boolean[board.length][board[0].length];
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(click[0]);
        q.add(click[1]);
        visited[click[0]][click[1]]= true;
        
        while(!q.isEmpty())
        {
            //System.out.println(q);
            int size= q.size();
            
            for(int ii=0;ii<size/2;ii++)
            {
                int row= q.poll();
                int col= q.poll();
                
                int count=0;
                for(int i=Math.max(0, row-1);i<= Math.min(board.length-1, row+1);i++)
                {
                    for(int j=Math.max(0, col-1); j<= Math.min(board[0].length-1, col+1);j++)
                    {
                        if(board[i][j]== 'M')
                            count++;
                    }
                }
                board[row][col]= count==0? 'B': ((char)(count+48));    
                
                if(board[row][col]== 'B')
                {
                    for(int i=Math.max(0, row-1);i<= Math.min(board.length-1, row+1);i++)
                    {
                        for(int j=Math.max(0, col-1); j<= Math.min(board[0].length-1, col+1);j++)
                        if(!visited[i][j])
                        { q.add(i); q.add(j); visited[i][j]= true; }
                    }
                }
            }
        }
        
        return board;
    }
}
