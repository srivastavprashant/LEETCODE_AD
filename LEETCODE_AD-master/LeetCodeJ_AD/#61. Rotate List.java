package LeetCodeJ;// 61. Rotate List

class Solution {
    public ListNode rotateRight(ListNode head, int k) 
    {
        if(null== head) return null;
        int len=0;
        ListNode curr= head, last= null;
        
        while(curr!= null)
        {
            last = curr;
            curr= curr.next;
            len++;
        }
        
        k=k%len;
        if(k==0) return head;
        k= len-k;
        curr= head;
        len=0;
        
        while(len+1!=k)
        {
            curr= curr.next;
            len++;
        }
        
        //System.out.println(curr.next.val);
        ListNode newHead= curr.next;
        curr.next= null;
        last.next= head;
        
        return newHead;
        
    }
}


// I did it again: 
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int len= 0;
        ListNode temp= head, saved= head;
        while(temp!= null) { temp= temp.next; len++; }
        
        if(len== 0) return head;
        k= k%len; temp= head;
        int count= 0;
        if(k== 0) return head;
        while(count!= len-k-1) { temp= temp.next; count++; }
        
        head= temp.next;
        temp.next= null;
        temp= head;
        while(temp.next!= null) temp= temp.next;
        temp.next= saved;
        return head;
    }
}
