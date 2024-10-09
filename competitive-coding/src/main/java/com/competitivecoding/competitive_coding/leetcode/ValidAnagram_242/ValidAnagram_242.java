package com.competitivecoding.competitive_coding.leetcode.ValidAnagram_242;

import com.competitivecoding.competitive_coding.base.ProblemSolver;

public class ValidAnagram_242 extends ProblemSolver {
    @Override
    public void solve() {
/*
        Solve here: Create Solution Object for leet Code else others and run its respective function.
        Solution solution = new Solution();
        Use IO operations like Ex: io.println();
*/
        Solution solution = new Solution();
        io.println(solution.isAnagram("rat", "car"));

    }

    public static void main(String[] args) throws Exception {
        new ValidAnagram_242().run();
    }
}
/*
 * For LeetCode
 * */

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26]; //using as dictionary
        for (int i = 0; i < s.length(); i++) {
            count[(int) s.charAt(i) - 97]++;
            count[(int) t.charAt(i) - 97]--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}