// #109. Convert Sorted List to Binary Search Tree


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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution 
{
    void call(ArrayList<Integer> arr, int start, int last, TreeNode root)
    {
        if(start> last) return;
        int mid= start+ (last- start)/2;
        root.val= arr.get(mid);
        
        if(mid-1>= start)
        {
            TreeNode left= new TreeNode();
            root.left= left;
            call(arr, start, mid-1, left);
        }
        
        if(mid+1<= last)
        {
            TreeNode right= new TreeNode();
            root.right= right;
            call(arr, mid+1, last, right);
        }
    }
    public TreeNode sortedListToBST(ListNode head) 
    {
        if(head== null) return null;
        ArrayList<Integer> arr= new ArrayList<>();
        while(head!=null)
        {
            arr.add(head.val);
            head= head.next;
        }
        
        TreeNode root= new TreeNode();
        call(arr, 0, arr.size()-1, root);
        
        return root;
    }
}
