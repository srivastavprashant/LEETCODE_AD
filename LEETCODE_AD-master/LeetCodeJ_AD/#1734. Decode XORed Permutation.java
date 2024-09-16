package LeetCodeJ;

// Solution 1: O(n^2) lets go for TLE
class Solution {
    public int[] decode(int[] encoded) {
        for(int i=1;i<=encoded.length+1;i++) {
            int[] ans = helper(encoded, i);
            if(ans.length == encoded.length+1) return ans;
        }
        
        return new int[]{};
    }
    
    public int[] helper(int[] arr, int x) {
        boolean possible = true;
        int[] ret = new int[arr.length+1];
        ret[ret.length-1] = x;
        
        for(int i=ret.length-2;i>=0;i--) {
            ret[i] = ret[i+1] ^ arr[i];
            if(ret[i]> ret.length || ret[i] <= 0) possible= false;
        }
        return possible ? ret : new int[]{};
    }
}

// Solution 2: O(n) 
class Solution {
    public int[] decode(int[] encoded) {
        int first = 0;
        for(int i= 1;i<encoded.length;i+=2) first^= encoded[i];
        for(int i=1;i<encoded.length+2;i++) first^= i;
        return helper(encoded, first);
    }
    
    public int[] helper(int[] arr, int x) {
        int[] ret = new int[arr.length+1];
        ret[0] = x;
        
        for(int i=1;i<ret.length;i++) ret[i] = ret[i-1] ^ arr[i-1];
        
        return ret;
    }
}
