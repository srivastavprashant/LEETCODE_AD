// #421. Maximum XOR of Two Numbers in an Array



class Solution 
{
    public int findMaximumXOR(int[] nums) 
    {
        int ans= 0;
        for(int ii= 30;ii>=0;ii--)
        {
            ans<<= 1;
            HashSet<Integer> set= new HashSet<>();
            for(int i: nums)
            {
                //System.out.println((i>> ii)+" "+ii);
                if(set.contains(ans^1^ (i>> ii)))
                { ans|= 1; break; }
                else
                    set.add((i>> ii));
            }
        }
        
        return ans;
    }
}
