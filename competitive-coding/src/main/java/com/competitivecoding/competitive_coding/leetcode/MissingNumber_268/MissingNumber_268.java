package com.competitivecoding.competitive_coding.leetcode.MissingNumber_268;

import com.competitivecoding.competitive_coding.base.ProblemSolver;

public class MissingNumber_268 extends ProblemSolver {
    @Override
    public void solve() {
/*
        Solve here: Create Solution Object for leet Code else others and run its respective function.
        Solution solution = new Solution();
        Use IO operations like Ex: io.println();
*/
        Solution solution = new Solution();

    }

    public static void main(String[] args) throws Exception {
        new MissingNumber_268().run();
    }
}
/*
 * For LeetCode
 * */

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum;
        if ((n & 1) == 1) { //checking for even/odd for n
            sum = ((n + 1) / 2) * n; //Using (n x (n+1)) /2 to calculate sum of natural numbers.
            //Since multiplication is costly operation, so checking for even odd as then we can divide by 2 for n or n+1
        } else {
            sum = (n / 2) * (n + 1);
        }
        for (int i : nums)
            sum -= i;
        return sum;
    }
}
