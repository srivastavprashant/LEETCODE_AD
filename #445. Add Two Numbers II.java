

class Solution 
{
    static int call(ListNode headA, ListNode headB)
    {
        if(headA==null && headB==null)
            return 0;
        else
        {
            int val= call(headA.next, headB.next);
            int sum= headA.val+ headB.val+ val;
            
            if(sum>9)
            {
                headA.val= sum-10;
                return 1;
            }
            else
            {
                headA.val= sum;
                return 0;
            }
        }
    }
    
    public ListNode addTwoNumbers(ListNode headA, ListNode headB) 
    {
        int lenA= 0, lenB=0;
        ListNode A=headA, B=headB;
        
        while(A!=null)
        {
            lenA++;
            A= A.next;
        }
        
        while(B!=null)
        {
            lenB++;
            B= B.next;
        }
        
        if(lenA==0)
            return headB;
        if(lenB==0)
            return headA;
        if(lenA<lenB)
        {   
            int tem=lenA;
            lenA= lenB;
            lenB= tem;
            ListNode temp= headA;
            headA= headB;
            headB= temp;
        }
        
        while(lenB!=lenA)
        {
            ListNode temp=new ListNode(0);
            temp.next=headB;
            headB= temp;
            lenB++;
        }
        int val= call(headA, headB);
        
        if(val==1)
        {
            ListNode temp=new ListNode(1);
            temp.next= headA;
            headA= temp;
        }
        return headA;
    }
}
