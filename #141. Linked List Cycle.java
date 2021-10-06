/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) 
    {
        if(head==null ||head.next==null)
            return false;
        ListNode i=head.next.next;
        //System.out.println(i==head);
        while(i!=null && i!=head)
        {
            if(i.next==null)
                return false;
            i=i.next.next;
            head=head.next;
            //System.out.println(i.val+"\t"+head.val);
        }
        if(i==null)
            return false;
        return true;
    }
}
