package com.competitivecoding.competitive_coding.leetcode.ValidParentheses_20;

import com.competitivecoding.competitive_coding.base.ProblemSolver;

import java.util.Stack;

public class ValidParenthesis_20 extends ProblemSolver {
    @Override
    public void solve() {
/*
        Solve here: Create Solution Object for leet Code else others and run its respective function.
        Solution solution = new Solution();
        Use IO operations like Ex: io.println();
*/
        Solution solution = new Solution();
        var inputString = io.nextLine();
        io.println(solution.isValid(inputString));

    }

    public static void main(String[] args) throws Exception {
        new ValidParenthesis_20().run();
    }
}
/*
 * For LeetCode
 * */

class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false; // Odd length will never be valid

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(': stack.push(')'); break;
                case '{': stack.push('}'); break;
                case '[': stack.push(']'); break;
                default:
                    if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }
        return stack.isEmpty();
    }
}

