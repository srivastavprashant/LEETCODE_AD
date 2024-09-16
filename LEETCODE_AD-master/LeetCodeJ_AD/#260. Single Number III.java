package LeetCodeJ;/*
  This one is a modification of a problem where we have an array and all the elements occur twice except for one.
    So, according to the properties of xor a^a= 0. 
  And we can actually use that to find the no which is not repeating by simply finding xor of the whole array.
  
  Now, we will do the same here too but after doing that we will take a set bit from the xor of array. Now according to the xor operator a bit is set if our ans will have that bit
  different.
  So from this observation we will devide the array one having that bit as set and other having that bit off. Now the question got reduced to finding one element thats not repeating.
*/

class Solution {
    public int[] singleNumber(int[] nums) 
    {
        int[] ans=new int[]{0,0};
        int xor=0;
        
        for(int i: nums)
            xor^= i;
        
        xor= xor& ~(xor-1);
        for(int i: nums)
            if((i & xor)==0)
                ans[0]^= i;
            else
                ans[1]^= i;
        return ans;
    }
}
