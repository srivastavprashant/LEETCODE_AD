package com.competitivecoding.competitive_coding.leetcode.UniquePaths_62;

import com.competitivecoding.competitive_coding.base.ProblemSolver;

import java.util.Arrays;

public class UniquePaths_62 extends ProblemSolver {
    @Override
    public void solve() {
/*
        Solve here: Create Solution Object for leet Code else others and run its respective function.
        Solution solution = new Solution();
        Use IO operations like Ex: io.println();
*/
        Solution solution = new Solution();
        io.print(solution.uniquePaths(3, 7));

    }

    public static void main(String[] args) throws Exception {
        new UniquePaths_62().run();
    }
}
/*
 * For LeetCode
 * */

class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) dp[i][j] = -1; //filling with -1
        dp[0][0] = 1;
        var answer = recursiveDPWithMemoization(m - 1, n - 1, dp);
        return answer;
    }

    private int recursiveDPWithMemoization(int m, int n, int[][] dp) {
        if (m == 0 && n == 0) return dp[m][n];
        if (dp[m][n] != -1) return dp[m][n]; // if already calculated, return value
        int leftCall = 0, upCall = 0;
        if (n - 1 >= 0)
            leftCall = recursiveDPWithMemoization(m, n - 1, dp);
        if (m - 1 >= 0)
            upCall = recursiveDPWithMemoization(m - 1, n, dp);
        dp[m][n] = leftCall + upCall;
        return dp[m][n];
    }
}