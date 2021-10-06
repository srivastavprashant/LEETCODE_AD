

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) 
    {
        ListNode i=head;
        int j=0;
        
        while(i!=null)
        {
            j++;
            i=i.next;
        }
        
        j=(j%2==0)?j/2:j/2+1;
        
        i=head;
        while(j--!=0)
        {
            i=i.next;
        }
        
        ListNode temp2=null;
        while(i!=null)
        {
            ListNode temp=i.next;
            i.next=temp2;
            temp2=i;
            i=temp;
        }
        
        while(temp2!=null)
        {
            if(head.val!=temp2.val)
                return false;
            head=head.next;
            temp2=temp2.next;        
        }
        return true;
}}
