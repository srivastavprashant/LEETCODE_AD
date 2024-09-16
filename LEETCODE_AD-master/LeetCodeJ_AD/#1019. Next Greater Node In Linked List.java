package LeetCodeJ;// 1019. Next Greater Node In Linked List

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
    public int[] nextLargerNodes(ListNode head) 
    {
        ListNode clone= head;
        int count=0;
        
        while(clone!=null)
        { clone= clone.next; count++; }
        
        int[] ans=new int[count]; 
        count=0;
        Stack<Integer[]> stack=new Stack<>();
        
        while(head!=null)
        {
            while(!stack.isEmpty() && stack.peek()[0]<head.val)
            { ans[stack.pop()[1]]= head.val;}
            
            stack.push(new Integer[]{head.val, count});
            count++;
            head= head.next;
        }
        return ans;
    }
}
