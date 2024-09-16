package LeetCodeJ;// #1672. Richest Customer Wealth



class Solution {
    public int maximumWealth(int[][] accounts) 
    {
        int max= 0;
        
        for(int[] i: accounts)
        {
            int temp=0;
            for(int j: i)
                temp+= j;
            
            max= Math.max(max, temp);
        }
        return max;
    }
}
