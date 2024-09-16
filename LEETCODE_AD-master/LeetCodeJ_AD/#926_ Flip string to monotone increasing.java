package LeetCodeJ;/*
  Approach: So basically a monotone string is a bunch of 0 and then some 1. (It can also be all 0 or all 1)
            If somehow we could find the index from where the 0 ends and 1 starts to make it monotone.
            So we can agree that every occurence of 1 is a candidate of that index we can just flip all 1 before that and all 0 after that to make it a monotone.
            But the challenge is to do so with minimum flips, for that we can do some pre processing to find all the 1 before a particular index.
            Then we just traverse from back counting the zero's and when we encounter a 1 we find the flips= no of one prior to that index and no of zero after it.
            
            O(N) space and time complexity.
*/

class Solution {
    public int minFlipsMonoIncr(String S) 
    {
        char[] ch= S.toCharArray();
        
        int zero=0, ans=Integer.MAX_VALUE;
        int[] one=new int[ch.length]; // presum array to calculate occurence of 1 till that index.
        int temp=0;
        
        for(int i=0;i<one.length;i++)
            one[i]= temp+= ch[i]=='1'? 1:0;
        
        for(int i=ch.length-1;i>=0;i--)
        {
            zero+= ch[i]=='0'? 1: 0;
            
            if(ch[i]=='1')
                ans= Math.min(ans, zero+ one[i]-1);
        }
        
        return Math.min(ans, one[one.length-1]);  // corner case when best case is to have all 0.
    }
}
