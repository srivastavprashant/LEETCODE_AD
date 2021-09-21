// #382. Linked List Random Node


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    List<Integer> li;
    public Solution(ListNode head) {
        li= new ArrayList<>();
        ListNode temp= head;
        while(temp!= null) { li.add(temp.val); temp= temp.next; }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int index= (int)(Math.random()*li.size());
        return li.get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
