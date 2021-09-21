// #83. Remove Duplicates from Sorted List


class Solution {
    public ListNode deleteDuplicates(ListNode head) {
       ListNode result = new ListNode(0);
        if(head== null)
            return head;
        
        int check=0;
        ListNode prev= head;
        while(head.next!=null) {
            if(head.val==head.next.val) head.next=head.next.next;
            else head=head.next;     
        }
        
        return prev;
    }
}
