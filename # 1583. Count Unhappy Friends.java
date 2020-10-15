

class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) 
    {
        int unhappy=0;
        int[] matched= new int[n];
        
        for(int i[]: pairs)
        {
            matched[i[0]]= i[1];
            matched[i[1]]= i[0];
        }
        
        outer: for(int i=0;i<n;i++)
        {
            for(int j: preferences[i])
            {
                if(j== matched[i]) break;
                
                for(int k: preferences[j])
                {   
                    if(k== matched[j]) break;
                    if(k==i) 
                    { unhappy++; System.out.println(i); continue outer; }
                }
            }
        }
        
        return unhappy;
    }
}
