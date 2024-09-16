package LeetCodeJ;// #148. Sort List



// merge sort in O(nlog n) time and O(1) space complexity
class Solution {
    public ListNode sortList(ListNode head) {
        if(head== null) return null;
        return helper(head);
    }
    
    ListNode helper(ListNode head) {
        if(head.next== null) return head;
        else {
            ListNode slow= head, fast= head;
            while(fast!= null && fast.next!= null && fast.next.next!= null) {
                fast= fast.next.next;
                slow= slow.next;
            }
            
            ListNode left= helper(slow.next);
            slow.next= null;
            ListNode right= helper(head);

            return merge(left, right);
        }
    }
    
    ListNode merge(ListNode left, ListNode right) {
        ListNode ret= null, curr= null;
        while(left!= null && right!= null) {
            if(left.val< right.val) {
                if(curr== null) { curr= left; ret= left; }
                else { curr.next= left; curr= curr.next; }
                left= left.next;
            } else {
                if(curr== null) { curr= right; ret= right; }
                else { curr.next= right; curr= curr.next; }
                right= right.next;
            }
        }
        
        if(left!= null) curr.next= left;
        if(right!= null) curr.next= right;
        return ret;
    }
}
