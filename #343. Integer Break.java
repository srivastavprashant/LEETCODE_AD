// #343. Integer Break



class Solution 
{
    int[] memo;
    int call(int n)
    {
        if(n== 0) return 1;
        else if(memo[n]!= 0) return memo[n];
        else
        {
            int max= 1;
            for(int i=1;i<=n;i++)
                max= Math.max(max, i*call(n-i));
            memo[n]= max;
            return max;
        }
    }
    public int integerBreak(int n) 
    {
        if(n== 2) return 1;
        if(n== 3) return 2;
        memo= new int[n+1];
        return call(n);
    }
}
