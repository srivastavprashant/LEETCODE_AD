package LeetCodeJ;// #1043. Partition Array for Maximum Sum


class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) 
    {
        int[] tabulation= new int[arr.length];
        
        for(int i=0;i<arr.length;i++)
        {
            int max= Integer.MIN_VALUE;
            for(int j=0;j<k && i-j>=0;j++)
            {
                max= Math.max(max, arr[i-j]);
                tabulation[i]= Math.max(tabulation[i], (j+1)*max+ (i-j-1<0? 0: tabulation[i-j-1]));
            }
        }
        
        return tabulation[arr.length-1];
    }
}
