package LeetCodeJ;// 36. Valid Sudoku

class Solution {
    public boolean isValidSudoku(char[][] board) 
    {
        for(int i=0;i<9;i++)
        {
            HashSet<Character> set= new HashSet<>();
            
            for(int j=0;j<9;j++)
            {
                if(board[i][j]!='.' && set.contains(board[i][j]))
                    return false;
                else
                    set.add(board[i][j]);
            }
        }
        
        
        for(int i=0;i<9;i++)
        {
            HashSet<Character> set= new HashSet<>();
            
            for(int j=0;j<9;j++)
            {
                if(board[j][i]!='.' && set.contains(board[j][i]))
                    return false;
                else
                    set.add(board[j][i]);
            }
        }
        
        for(int row=0;row<3;row++)
        {
            for(int col=0;col<3;col++)
            {
                HashSet<Character> set= new HashSet<>();
                for(int i=0;i<3;i++)
                {
                    for(int j=0;j<3;j++)
                    {
                        int ii= i+ 3*row;
                        int jj= j+ 3*col;
                        if(board[ii][jj]!='.' && set.contains(board[ii][jj]))
                            return false;
                        else
                            set.add(board[ii][jj]);
                    }
                }
            }
        }
        
        return true;
    }
}

