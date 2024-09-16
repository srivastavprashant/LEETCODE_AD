package LeetCodeJ;// #24. Swap Nodes in Pairs



class Solution {
    public ListNode swapPairs(ListNode head)
    {
        if(head==null || head.next==null)
            return head;
        ListNode ret= head.next;
        ListNode prev= null;
        while(head!=null && head.next!=null)
        {
            if(prev!=null)
                prev.next= head.next; 
            ListNode temp= head.next;
            head.next= head.next.next;
            temp.next= head;
            prev= head;
            head= head.next;
            //System.out.println(head.val);
        }
        return ret;
        
    }
}
