package LeetCodeJ;//#1860. Incremental Memory Leak



class Solution {
    public int[] memLeak(int m1, int m2) {
        int i= 1;
        
        while(true) {
            if(m1>= m2) {
                if(i<= m1) m1-= i;
                else break;
            }
            else {
                if(i<= m2) m2-= i;
                else break;
            }
            
            i++;
        }
        
        return new int[]{i, m1, m2};
    }
}
