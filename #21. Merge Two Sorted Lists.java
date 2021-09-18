// #21. Merge Two Sorted Lists



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
    public ListNode mergeTwoLists(ListNode head1, ListNode head2)
    {
        if(head1==null)
            return head2;
        else if(head2==null)
            return head1;
        ListNode ret= head1;
        ListNode prev= null;
        while(head1!=null && head2!=null)
        {
            if(head1.val< head2.val)
            {
                prev=head1;
                head1= head1.next;
            }
            else
            {
                if(prev==null)
                {
                    ListNode temp=head2;
                    head2= head2.next;
                    temp.next= head1;
                    ret= temp;
                    prev= temp;
                }
                else
                {
                    ListNode insert= head2;
                    head2= head2.next;
                    prev.next= insert;
                    insert.next= head1;
                    prev =insert;
                }
            } 
        }
        
        if(head2!=null)
        {
            prev.next= head2;
        }
        return ret;
    }
}
