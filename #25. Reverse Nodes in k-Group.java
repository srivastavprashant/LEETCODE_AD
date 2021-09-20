// #25. Reverse Nodes in k-Group



// With O(1) extra space.
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len= 0;
        ListNode temp= head;
        while(temp!= null) { temp= temp.next; len++; }
        if(k== 1) return head;
        
        int i= 0;
        while(i+k<= len) {
            int count= k;
            ListNode prev= head;
            while(count!= 0) { prev= prev.next; count--; }
            
            helper(prev, head, k, i== 0);
            i+= k;
            if(i+k<= len) {
                count= k;
                ListNode _prev= head;
                while(count!= 0) { _prev= _prev.next; count--; }
                head.next= _prev;
            }
            head= prev;
        }
        
        return ans;
    }
    
    ListNode ans= null;
    void helper(ListNode prev, ListNode curr, int k, boolean b) {
        while(k!= 0) {
            ListNode temp= curr.next;
            curr.next= prev;
            prev= curr;
            curr= temp;
            k--;
        }
        
        // System.out.println(prev);
        ans= b? prev: ans;
    }
}
