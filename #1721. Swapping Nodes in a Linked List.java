// #1721. Swapping Nodes in a Linked List


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
    public ListNode swapNodes(ListNode head, int _k) 
    {
        int len= 0;
        ListNode temp= head;
        while(temp!= null)
        {
            temp= temp.next;
            len++;
        }
        
        if(len== 1) return head;
        
        
        ListNode prevk= null;
        if(_k!= 1)
        {
            prevk= null;
            prevk= head;
            int count= 0;
            while(++count!=_k-1)
            prevk= prevk.next;
        }
        
        ListNode prevk2= null;
        if(len!= _k)
        {
            prevk2= null;
            prevk2= head;
            int count= 0;
            while(++count!=len-_k)
                prevk2= prevk2.next;
        }
        
        ListNode k= (_k!= 1?prevk.next: head);
        ListNode k2= ( _k!= len? prevk2.next: head);
        
        //System.out.println(k.val+" "+k2.val);
        if(_k!= 1)prevk.next= k2;
        if(_k!= len)prevk2.next= k;
        ListNode tem= k.next;
        k.next= k2.next;
        k2.next= tem;
        
        return _k==1? k2: _k!= len? head: k;
    }
}
