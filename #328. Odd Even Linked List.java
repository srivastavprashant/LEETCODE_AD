
class Solution {
    public ListNode oddEvenList(ListNode head) 
    {
        if(head==null || head.next==null || head.next.next==null)
            return head;
        else
        {
            ListNode ret= head;
            ListNode odd= head; head= head.next;
            ListNode even= head; head= head.next;
            
            while(head!=null)
            {
                if(head.next!=null)
                {
                    ListNode temp2= head.next;
                    ListNode temp= odd.next;
                    odd.next= head;
                    head.next= temp;
                    even.next= temp2;
                    
                    odd= head;
                    even= temp2;
                    head= temp2.next;
                }
                else
                {
                    ListNode temp= odd.next;
                    odd.next= head;
                    head.next= temp;
                    even.next= null;
                    head= null;
                }
            }
            return ret;
        }
        
    }
}
