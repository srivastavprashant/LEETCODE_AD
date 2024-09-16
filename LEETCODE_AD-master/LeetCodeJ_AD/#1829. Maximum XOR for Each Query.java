package LeetCodeJ;// #1829. Maximum XOR for Each Query



class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] prefix= new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            prefix[i]= nums[i]^(i!= 0? prefix[i-1]: 0);
        }
        
        int[] ans= new int[nums.length]; 
        int c= 0;
        for(int i=nums.length-1;i>=0;i--) {
            int k= (int)(prefix[i]^((1l<<31)-1));
            k= k&((1<<maximumBit)-1);
            ans[c++]= k;
        }
        
        return ans;
    }
}
