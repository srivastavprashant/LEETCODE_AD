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
    public ListNode[] splitListToParts(ListNode head, int k)
    {
        int len=0;
        ListNode head_temp= head;
        while(head!=null)
        {
            len++;
            head= head.next;
        }
        head= head_temp;
        int size= len/k;
        int j=len%k;
        int i=0, c=0;
        ListNode[] ans=new ListNode[k];
        while(k--!=0)
        {
            int val= size;
            if(i<j)
                val=val+1;
            //System.out.println(head.val);
            ans[c++]=(head);
            ListNode prev= null;
            while(val!=0)
            {
                prev= head;
                head= head.next;
                val--;
            }
            
            if(prev!=null)
                prev.next= null;
            i++;
        }
        return ans;
    }
}
