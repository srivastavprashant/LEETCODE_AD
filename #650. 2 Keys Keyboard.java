// #650. 2 Keys Keyboard


class Solution 
{
    int[][] memo;
    int call(int N, int n, int len)
    {
        if(len>n) return 10000;
        else if(len== n) return 2;
        else if(memo[n][len]!= 0) return memo[n][len];
        else
        {
            int step= 1+ Math.min(call(N, n-len, len), (len!= N-n? call(N, n, N-n): Integer.MAX_VALUE));
            memo[n][len]= step;
            return step;
        }
    }
    public int minSteps(int n) {
        if(n== 1) return 0;
        memo= new int[n+1][n+1];
        return call(n, n-1, 1);
    }
}
