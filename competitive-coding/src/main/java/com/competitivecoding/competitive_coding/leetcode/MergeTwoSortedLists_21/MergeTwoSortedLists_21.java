package com.competitivecoding.competitive_coding.leetcode.MergeTwoSortedLists_21;

import com.competitivecoding.competitive_coding.base.ProblemSolver;

public class MergeTwoSortedLists_21 extends ProblemSolver {
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
        new MergeTwoSortedLists_21().run();
    }
}
/*
 * For LeetCode
 * */

class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return finalMerge(list1, list2);
    }

    public ListNode finalMerge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val <= list2.val) {
            list1.next = finalMerge(list1.next, list2);
            return list1;
        } else {
            list2.next = finalMerge(list1, list2.next);
            return list2;
        }
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
