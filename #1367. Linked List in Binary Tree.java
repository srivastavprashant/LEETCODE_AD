// #1367. Linked List in Binary Tree


class Solution {
    ListNode _head;
    Map<TreeNode, Set<ListNode>> map;
    public boolean isSubPath(ListNode head, TreeNode root) {
        _head= head;
        map= new HashMap<>();
        return helper(head, root);
    }
    
    boolean helper(ListNode head, TreeNode root) {
        if(head== null) return true;
        else if(root== null) return false;
        else if(map.containsKey(root) && map.get(root).contains(head)) return false;
        else {
            boolean ret= false;
            if(head.val== root.val) {
                ret|= helper(head.next, root.left); if(ret) return ret;
                ret|= helper(head.next, root.right); if(ret) return ret;
            } 
            
            ret|= helper(_head, root.left); if(ret) return ret;
            ret|= helper(_head, root.right); if(ret) return ret;
            if(!map.containsKey(root)) map.put(root, new HashSet<>());
            map.get(root).add(head);
            return ret;
        }
    }
}
