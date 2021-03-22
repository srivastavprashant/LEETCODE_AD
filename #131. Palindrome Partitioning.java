// #131. Palindrome Partitioning



class Solution 
{
    List<List<String>> ans;
    void call(String s, List<String> ans, List<List<Integer>> arr, int index)
    {
        if(index>= s.length()) { this.ans.add(new ArrayList<>(ans)); return; }
        else
        {
            for(int i: arr.get(index))
            {
                ans.add(s.substring(index, i+1));
                call(s, ans, arr, i+1);
                ans.remove(ans.size()-1);
            }
        }
    }
        
    public List<List<String>> partition(String s) {
        int n= s.length();
        boolean[][] tab= new boolean[n][n+1];
        for(int i=0;i<n;i++)
            for(int j=0;j<=i+1;j++)
                tab[i][j]= true;
        
        for(int i= n-2;i>=0;i--)
        {
            for(int j= i+1;j<=n;j++)
                if(s.charAt(i)== s.charAt(j-1) && tab[i+1][j-1])
                    tab[i][j]= true;
        }
        
        List<List<Integer>> arr= new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            List<Integer> temp= new ArrayList<>();
            for(int j=1+i;j<n+1;j++)
                if(tab[i][j]) temp.add(j-1);
         
            arr.add(temp);
        }
            
        ans= new ArrayList<>();
        call(s, new ArrayList<>(), arr, 0);
        
        return ans;
    }
}

// to do this efficiently we will need every palin substr.
// we can calculate that in O(N^2) time complexity using dp(tabulation).
