// #86. Partition List



class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small= null,small_start=null, big= null, big_start= null;
        while(head!= null) {
            if(head.val< x) {
                if(small== null) { small_start= head; small= head; }
                else { small.next= head; small= small.next; }
            } else {
                if(big== null) { big= head; big_start= head; }
                else { big.next= head; big= big.next; }
            }
            head= head.next;
        }
        if(big!= null) big.next= null;
        if(small!= null) small.next= null;
        
        if(small== null) return big_start;
        else {
            small.next= big_start; 
            return small_start;
        }
    }
}
