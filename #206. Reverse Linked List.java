

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
class Solution 
{
    static ListNode reverseLinkedList(ListNode temp, ListNode head)
    {
        if(head==null)
            return temp;
        else
        {
            ListNode store= head.next;
            head.next= temp;
            return reverseLinkedList(head, store);
        }
    }
    
    public ListNode reverseList(ListNode head) 
    {
        ListNode temp= null;
        
        //METHOD 1: RECURSIVE
        return reverseLinkedList(temp, head);
        
        // METHOD 2: ITERATIVE
        
        /*while(head!=null)
        {
            ListNode store= head.next;
            head.next= temp;
            temp= head;
            head= store;
        }
        return temp;
        */
    }
}
