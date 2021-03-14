// #647. Palindromic Substrings



class Solution 
{
    public int countSubstrings(String s) 
    {
        char[] arr= s.toCharArray();
        boolean[][] tabulation= new boolean[arr.length][arr.length];
        for(boolean[] i: tabulation)
            Arrays.fill(i, true);
        
        int ans= 0;
        for(int i= arr.length-1;i>=0;i--)
        {
            for(int j= i;j<arr.length;j++)
                tabulation[i][j]= arr[i]== arr[j] && 
                (i+1<arr.length&& j-1>-1? tabulation[i+1][j-1]: true); 
            
            for(int j= i;j<arr.length;j++)
                ans+= tabulation[i][j]?1:0;
        }
        
        return ans;
    }
}
