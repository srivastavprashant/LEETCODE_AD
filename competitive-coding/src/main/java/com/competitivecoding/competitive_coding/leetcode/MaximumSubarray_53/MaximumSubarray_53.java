package com.competitivecoding.competitive_coding.leetcode.MaximumSubarray_53;

import com.competitivecoding.competitive_coding.base.ProblemSolver;

import java.util.Arrays;

public class MaximumSubarray_53 extends ProblemSolver {
    @Override
    public void solve() {
/*
        Solve here: Create Solution Object for leet Code else others and run its respective function.
        Solution solution = new Solution();
        Use IO operations like Ex: io.println();
*/
        Solution solution = new Solution();
        var numbers = Arrays.stream(io.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        io.println(solution.maxSubArray(numbers));

    }

    public static void main(String[] args) throws Exception {
        new MaximumSubarray_53().run();
    }
}
/*
 * For LeetCode
 * */

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int maxg = nums[0], maxc = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxc = Math.max(maxc + nums[i], nums[i]);
            if (maxc > maxg) {
                maxg = maxc;
            }
        }
        return maxg;
    }
}
