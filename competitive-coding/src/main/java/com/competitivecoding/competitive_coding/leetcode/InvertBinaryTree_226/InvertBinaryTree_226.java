package com.competitivecoding.competitive_coding.leetcode.InvertBinaryTree_226;

import com.competitivecoding.competitive_coding.base.ProblemSolver;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree_226 extends ProblemSolver {
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
        new InvertBinaryTree_226().run();
    }
}
/*
 * For LeetCode
 * */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    return null;
       //incomplete
    }
}
