package LeetCodeJ;// #967. Numbers With Same Consecutive Differences


class Solution 
{
    static HashSet<Integer> ans;
    static void DFSREC(int n, int curr, int k, int number)
    {
        if(curr<0 || curr> 9)
            return;
        
        if(n== 0)
            ans.add(number);
        else
        {
            number= number*10+ curr;
            DFSREC(n-1, curr-k, k, number);
            DFSREC(n-1, curr+k, k, number);
        }
    }
    public int[] numsSameConsecDiff(int n, int k) 
    {
        ans= new HashSet<>();
        for(int i=1;i<=9;i++)
            DFSREC(n, i, k, 0);
        
        int[] fans= new int[ans.size()];
        int count= 0;
        for(int i: ans)
            fans[count++]= i;
        
        return fans;
    }
}
