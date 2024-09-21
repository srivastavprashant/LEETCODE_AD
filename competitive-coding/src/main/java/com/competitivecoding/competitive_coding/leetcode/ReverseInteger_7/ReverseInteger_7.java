package com.competitivecoding.competitive_coding.leetcode.ReverseInteger_7;

import com.competitivecoding.competitive_coding.base.ProblemSolver;

public class ReverseInteger_7 extends ProblemSolver {
    @Override
    public void solve() {
/*
        Solve here: Create Solution Object for leet Code else others and run its respective function.
        Solution solution = new Solution();
        Use IO operations like Ex: io.println();
*/
        Solution solution = new Solution();
        var input = io.nextInt();
        io.print(solution.reverse(input));

    }

    public static void main(String[] args) throws Exception {
        new ReverseInteger_7().run();
    }
}
/*
 * For LeetCode
 * */

class Solution {
    public int reverse(int x) {
        var maxState = (Integer.MAX_VALUE / 10);
        var minState = (Integer.MIN_VALUE / 10);
        var solution = 0;
        while (x != 0) {
            var d = x % 10;
            if (solution > maxState || solution < minState) {
                return 0;
            }
            solution = solution * 10 + d;
            x /= 10;
        }
        return solution;
    }
}