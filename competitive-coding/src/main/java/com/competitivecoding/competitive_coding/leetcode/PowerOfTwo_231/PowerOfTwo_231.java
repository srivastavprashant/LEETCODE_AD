package com.competitivecoding.competitive_coding.leetcode.PowerOfTwo_231;

import com.competitivecoding.competitive_coding.base.ProblemSolver;

public class PowerOfTwo_231 extends ProblemSolver {
    @Override
    public void solve() {
        //solve here: Create Solution Object for leet Code else others and run its respective function.
//        Solution solution = new Solution();
//        Use io Ex: io.println();
        Solution solution = new Solution();
        var input = io.nextInt();
        io.print(solution.isPowerOfTwo(input));
    }

    public static void main(String[] args) throws Exception {
        new PowerOfTwo_231().run();
    }
}

class Solution {
    //for LeetCode
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
}