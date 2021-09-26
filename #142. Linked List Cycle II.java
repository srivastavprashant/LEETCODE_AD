// #142. Linked List Cycle II



// Floyd's cycle detection algorithm
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode hare= head, tortoise= head;
        while(hare!= null && hare.next!= null) {
            tortoise= tortoise.next;
            hare= hare.next.next;
            
            if(hare== tortoise) return helper(hare, tortoise, head);
        }
        return null;
    }
    
    ListNode helper(ListNode hare, ListNode tortoise, ListNode head) {
        tortoise= head;
        while(tortoise!= hare) {
            hare= hare.next;
            tortoise= tortoise.next;
        }
        return hare;
    }
}
