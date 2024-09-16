package LeetCodeJ;// #712. Minimum ASCII Delete Sum for Two Strings



class Solution 
{
    int[][] memo;
    int[] suffix_i, suffix_j;
    int dfs(char[] arr, char[] arr2, int i, int j)
    {
        if(i>= arr.length && j< arr2.length) return suffix_j[j];
        else if(j>= arr2.length && i< arr.length) return suffix_i[i];
        else if(i>= arr.length && j>= arr2.length) return 0;
        else if(memo[i][j]!= 0) return memo[i][j];
        else
        {
            if(arr[i]== arr2[j])
            {
                memo[i][j]= dfs(arr, arr2, i+1, j+1);
                return memo[i][j];
            }
            else
            {
                int ans= dfs(arr, arr2, i+1, j)+ arr[i];
                ans= Math.min(ans, dfs(arr, arr2, i, j+1)+ arr2[j]);
                
                memo[i][j]= ans;
                return ans;
            }
        }
    }
    
    public int minimumDeleteSum(String s1, String s2) 
    {
        suffix_i= new int[s1.length()];
        suffix_j= new int[s2.length()];
        char[] arr= s1.toCharArray();
        char[] arr2= s2.toCharArray();
        memo= new int[arr.length][arr2.length];
        
        for(int i= arr.length-1;i>=0;i--)
            suffix_i[i]= (i!= arr.length-1? suffix_i[i+1]: 0)+ arr[i];
        
        for(int i= arr2.length-1;i>=0;i--)
            suffix_j[i]= (i!= arr2.length-1? suffix_j[i+1]: 0)+ arr2[i];
        
        return dfs(arr, arr2, 0, 0);
    }
}
