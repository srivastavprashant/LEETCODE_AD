// #1669. Merge In Between Linked Lists



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

/*
    So basically we will have 

*/
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) 
    {
        ListNode start= null, last= null;
        ListNode head= list1, prev= null;
        
        while(head!=null)
        {
            if(head.val== a)
                start= prev;
            
            if(head.val== b)
                last= head;
            
            prev= head;
            head= head.next;
        }
        
        if(start!= null)
            start.next= list2;
        
        head= list2;
        while(head.next!=null)
            head= head.next;
        
        head.next= last.next;
        
        return list1;
    }
}
