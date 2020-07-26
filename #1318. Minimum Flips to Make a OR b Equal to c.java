/*
  Just gonna traverse through all the bits(max 32 as they are int) if c has that bit set and neither a nor b has bit as set then +1
  If c has bit as 0 , then ans+ = that bit value of a and b
*/

class Solution {
    public int minFlips(int a, int b, int c)
    {
        int ans=0, i=0;
        
        while(i!=32)
        {
            int val= a&1;
            int val2= b&1;
            int val3= c&1;
            
            if(val3==0)
                ans+= val+ val2;
            else
                ans+= (val==1||val2==1)? 0: 1;
            
            i++; val>>=1; a>>=1; b>>=1; c>>=1;
        }
        return ans;
    }
}
