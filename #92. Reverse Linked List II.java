// #92. Reverse Linked List II



class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int curr= 1;
        ListNode checkpoint= null, leftnode= null, save= head;
        ListNode rightnode= null, prev= null, checkpoint2= null;
        while(head!= null) {
            if(curr== left-1) checkpoint= head;
            if(curr== left) leftnode= head;
            if(curr== right) rightnode= head;
            if(curr== right+1) checkpoint2= head;
            else if(curr>= left && curr<= right) {
                ListNode temp= head.next;
                head.next= prev;
                prev= head;
                head= temp;
                curr++;
                continue;
            }
            head= head.next;
            curr++;
        }
        
        if(checkpoint!= null) checkpoint.next= rightnode;
        leftnode.next= checkpoint2;
        return checkpoint== null? rightnode: save;
    }
}
