// #82. Remove Duplicates from Sorted List II



class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode save= head, prev= null;
        while(head!= null) {
            ListNode temp= head;
            while(temp!= null && temp.val== head.val) temp= temp.next;
            
            if(head.next!= temp) {
                if(prev== null) save= temp;
                else prev.next= temp;
                head= temp;
            } 
            else {
                prev= head;
                head= head.next;
            }
        }
        
        return save;
    }
}
