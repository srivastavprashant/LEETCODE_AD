// #143. Reorder List


class Solution {
    public void reorderList(ListNode head) {
        ListNode hare= head, tortoise= head;
        while(hare!= null && hare.next!= null) { 
            hare= hare.next.next;
            tortoise= tortoise.next;
        }
        
        ListNode head2= reverse(hare!= null? tortoise.next: tortoise);
        while(head2!= null) {
            ListNode save_head= head.next, save_head2= head2.next;
            head2.next= head.next;
            head.next= head2;
            head= save_head;
            head2= save_head2;
        }
        head.next= null;
    }
    
    ListNode reverse(ListNode head) {
        ListNode prev= null;
        while(head!= null) {
            ListNode save= head.next;
            head.next= prev;
            prev= head;
            head= save;
        }
        
        return prev;
    }
}
