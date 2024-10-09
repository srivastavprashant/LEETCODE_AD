package com.competitivecoding.competitive_coding.leetcode.BinarySearch_704;

import com.competitivecoding.competitive_coding.base.ProblemSolver;

public class BinarySearch_704 extends ProblemSolver {
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
        new BinarySearch_704().run();
    }
}
/*
 * For LeetCode
 * */

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1; // target not found
    }
}