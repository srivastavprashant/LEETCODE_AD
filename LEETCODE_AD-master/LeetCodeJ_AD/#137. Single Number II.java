#137. Single Number II



class Solution {
    public int singleNumber(int[] nums) 
    {
        int ans= 0;
        for(int i=0;i<=31;i++)
        {
            int freq= 0;
            for(int j: nums)
                freq+= ((j&(1<< i))== 0? 0: 1);
            
            if(freq%3== 1)
                ans|= (1<<i);
        }
        
        return ans;
    }
}
/*
    So we are looking for a number that occurs just once.
    Approach 1: HashMap O(N) time and space complexity.
    Approach 2: we can sort the whole array and then find O(nlog n) and O(1).
    
    Approach 3: lets the about the number as a 32 bit number.(negative value are possible)
                Know if we calculate the number of occurrence for each bit then everytime 
                it will be either 3 || 0 if the number that occured just once does'nt has
                that bit as set.
                
                when the freq comes as 1 then we know that the number that has occurred once 
                has that bit as set.

*/
