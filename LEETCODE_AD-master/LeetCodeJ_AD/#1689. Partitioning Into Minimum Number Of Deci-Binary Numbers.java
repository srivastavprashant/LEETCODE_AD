package LeetCodeJ;// #1689. Partitioning Into Minimum Number Of Deci-Binary Numbers

class Solution {
    public int minPartitions(String n) 
    {
        int ans= -1;
        for(char c: n.toCharArray())
            ans= Math.max(c-48, ans);
        
        return ans;
    }
}
