// 19. Remove Nth Node From End of List


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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len= 0;
        ListNode temp= head;
        while(temp!= null) { temp= temp.next; len++; }
        if(len== 1) return null;
        if(0== len- n) return head.next; 
        
        int curr= 1;
        temp= head;
        while(curr!= len- n) { temp= temp.next; curr++; }
        
        temp.next= temp.next.next;
        return head;
    }
}
