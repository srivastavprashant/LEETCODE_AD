

public class Solution 
{
    static ListNode moveForward(int len_a, int len_b, ListNode headA)
    {
        int i=0;
        
        while(i!=len_a-len_b)
        {
            headA= headA.next;
            i++;
        }
        return headA;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        ListNode tempa= headA, tempb= headB; 
        int len_a= 0;
        while(headA!=null)
        {
            headA=headA.next;
            len_a++;
        }
        
        int len_b= 0;
        while(headB!=null)
        {
            len_b++;
            headB= headB.next;
        }
        headA= tempa;
        headB= tempb;
        
        if(len_a<len_b)
            headB= moveForward(len_b, len_a, headB);
        else
            headA= moveForward(len_a, len_b, headA);
        
        while(headA!=null)
            if(headA==headB)
                return headA;
            else
            {
                headA= headA.next;
                headB= headB.next;
            }
        
        return null;
    }
}
