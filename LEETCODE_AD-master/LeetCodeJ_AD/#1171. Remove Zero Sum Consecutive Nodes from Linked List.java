package LeetCodeJ;// #1171. Remove Zero Sum Consecutive Nodes from Linked List


class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map= new HashMap<>();
        map.put(0, null);
        boolean bool= false;
        ListNode temp= head;
        int sum= 0;
        while(temp!= null) {
            sum+= temp.val;
            if(map.containsKey(sum)) {
                if(map.get(sum)== null) head= temp.next;
                else map.get(sum).next= temp.next;
                map.put(sum, temp);
                bool= true;
            } else map.put(sum, temp);
            temp= temp.next;
        }
        
        return bool?removeZeroSumSublists(head): head;
    }
}
