package com.competitivecoding.competitive_coding.leetcode.LinkedListCycle_141;

import com.competitivecoding.competitive_coding.base.ProblemSolver;

public class LinkedListCycle_141 extends ProblemSolver {
    @Override
    public void solve() {
/*
        Solve here: Create Solution Object for leet Code else others and run its respective function.
        Solution solution = new Solution();
        Use IO operations like Ex: io.println();
*/
        Solution solution = new Solution();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);

        head.next.next = new ListNode(0);

        head.next.next.next = new ListNode(-4);

        head.next.next.next.next = head.next;

        io.println(solution.hasCycle(head));


    }

    public static void main(String[] args) throws Exception {
        new LinkedListCycle_141().run();
    }
}
/*
 * For LeetCode
 * */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}


class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        if (head.next == head) return true;
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        do {
            if (fastPointer.next == null || fastPointer.next.next == null) return false;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        } while (slowPointer != fastPointer);
        return true;
    }
}