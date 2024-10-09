package com.competitivecoding.competitive_coding.leetcode.ValidPalindrome_125;

import com.competitivecoding.competitive_coding.base.ProblemSolver;

public class ValidPalindrome_125 extends ProblemSolver {
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
        new ValidPalindrome_125().run();
    }
}
/*
 * For LeetCode
 * */

class Solution {
    public boolean isPalindrome(String s) {
        var leftPointer = 0;
        var rightPointer = s.length() - 1;
        while (leftPointer < rightPointer) {
            while (leftPointer < rightPointer && !Character.isLetterOrDigit(s.charAt(leftPointer))) {
                leftPointer++;
            }
            while (leftPointer < rightPointer && !Character.isLetterOrDigit(s.charAt(rightPointer))) {
                rightPointer--;
            }
            if (Character.toLowerCase(s.charAt(leftPointer)) != Character.toLowerCase(s.charAt(rightPointer))) {
                return false;
            }
            leftPointer++;
            rightPointer--;
        }
        return true;
    }
}