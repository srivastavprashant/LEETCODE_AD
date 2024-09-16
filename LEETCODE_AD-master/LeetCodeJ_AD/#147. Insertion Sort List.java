package LeetCodeJ;// #147. Insertion Sort List

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode curr= head.next, prev= head;
        while(curr!= null) {
            ListNode tcurr= curr.next;
            ListNode temp= head, tprev= null;
            while(temp.val<= curr.val && temp!= curr) {
                tprev= temp;
                temp= temp.next;
            }
            
            if(tprev== null) {
                prev.next= curr.next;
                curr.next= head;
                head= curr;
            }
            else if(temp!= curr) {
                prev.next= curr.next;
                tprev.next= curr;
                curr.next= temp;
            } 
            
            curr= tcurr;
            if(prev.next!= curr) prev= prev.next;
        }
        
        return head;
    }
    
    void debug(ListNode head, String s) {
        System.out.print(s+" ");
        while(head!= null) {
            System.out.print(head.val+" ");
            head= head.next;
        }
        System.out.println();
    }
}
