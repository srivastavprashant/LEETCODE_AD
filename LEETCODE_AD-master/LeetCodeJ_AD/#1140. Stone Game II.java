package LeetCodeJ;// 1140. Stone Game II



class Solution 
{
    int[][] memo;
    int call(int[] piles, int index, int m, int sum)
    {
        if(index>= piles.length) return 0;
        else if(memo[index][m]!= 0) return memo[index][m];
        else
        {
            int val= 0, max= 0;
            for(int x= 0;x< 2*m && index+x< piles.length;x++)
            {
                val+= piles[index+x];
                max= Math.max(max, sum- call(piles, index+x+1, Math.max(m, x+1), sum- val));
            }
             
            memo[index][m]= max;
            return max;
        }
    }
    
    public int stoneGameII(int[] piles) 
    {
        int sum= 0;
        for(int i: piles)
            sum+= i;
        
        memo= new int[piles.length][piles.length+1];
        return call(piles, 0, 1, sum);
    }
}
