

class Solution {
    public ListNode removeElements(ListNode head, int val) 
    {
        ListNode prev= null, ret= head;
        
        while(head!=null)
        {
            if(head.val== val)  // remove that node
            {
                if(prev!= null)
                {
                    prev.next= head.next;
                    head= prev.next;
                }
                else
                {
                    ret= head.next;
                    head= head.next;
                }
            }
            else
            {
                prev= head;
                head= head.next;
            }
        }
        
        return ret;
    }
}
