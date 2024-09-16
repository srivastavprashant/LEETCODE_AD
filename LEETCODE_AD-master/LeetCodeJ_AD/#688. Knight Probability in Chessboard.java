package LeetCodeJ;// #688. Knight Probability in Chessboard



class Solution 
{
    double[][][] memo;
    double call(int n, int k, int r, int c)
    {
        if(r>= n || c>= n || r<0 || c<0) return 0;
        else if(k== 0) return 1;
        else if(memo[r][c][k]!= 0) return memo[r][c][k];
        else
        {
            double val= call(n, k-1, r+2, c+1)/8.0d;
            val+= call(n, k-1, r+2, c-1)/8.0d;
            val+= call(n, k-1, r+1, c+2)/8.0d;
            val+= call(n, k-1, r+1, c-2)/8.0d;
            val+= call(n, k-1, r-2, c-1)/8.0d;
            val+= call(n, k-1, r-2, c+1)/8.0d;
            val+= call(n, k-1, r-1, c+2)/8.0d;
            val+= call(n, k-1, r-1, c-2)/8.0d;
            
            memo[r][c][k]= val;
            return val;
        }
    }
    
    public double knightProbability(int n, int k, int r, int c) {
        memo= new double[n][n][k+1];
        return call(n, k, r, c);
    }
}
