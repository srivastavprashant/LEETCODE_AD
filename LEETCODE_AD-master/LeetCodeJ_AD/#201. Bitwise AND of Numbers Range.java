package LeetCodeJ;

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int ans = 0;
        for(int i=0;i<31;i++) {
            int val = 1<<i;
            if((left&val)!= 0 && (right&val)!= 0 && right-left< val) {
                ans|= val;
            }
        }
        
        return ans;
    }
}
