package LeetCodeJ;// #1869. Longer Contiguous Segments of Ones than Zeros


class Solution {
    public boolean checkZeroOnes(String s) {
        return count(s.toCharArray(), '1')>count(s.toCharArray(), '0');
    }
    
    int count(char[] arr, char ch) {
        int ret= 0, cou= 0;
        for(char c: arr) {
            if(c== ch) cou++;
            else cou= 0;
            
            ret= Math.max(ret, cou);
        }
        
        return ret;
    }
}
