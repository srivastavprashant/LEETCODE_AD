package com.competitivecoding.competitive_coding.leetcode.ComplementOfBase10Integer_1009;

import com.competitivecoding.competitive_coding.base.ProblemSolver;

public class ComplementOfBase10Integer_1009 extends ProblemSolver {
    @Override
    public void solve() {
        //solve here: Create Solution Object for leet Code else others and run its respective function.
//        Solution solution = new Solution();
//        Use io Ex: io.println();
        Solution solution = new Solution();
        var input = io.nextInt();
        io.print(solution.bitwiseComplement(input));
    }

    public static void main(String[] args) throws Exception {
        new ComplementOfBase10Integer_1009().run();
    }
}

class Solution {
    //for LeetCode
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        StringBuilder answer = new StringBuilder(64);
        while (n != 0) {
            if ((n & 1) == 1) {
                answer.append("0");
            } else {
                answer.append("1");
            }
            n = n >> 1;
        }
        answer.reverse();
        return Integer.parseInt(answer.toString(), 2);
    }
}