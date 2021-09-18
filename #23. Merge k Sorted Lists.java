// # 23. Merge k Sorted Lists



class Solution {
    class Set {
        ListNode node;
        int index;
        
        Set(ListNode node, int index) {
            this.node= node;
            this.index= index;
        }
    }

    
    public ListNode mergeKLists(ListNode[] lists) {
        Set[] list= new Set[lists.length];
        for(int i=0;i<list.length;i++) list[i]= new Set(lists[i], i);
        TreeSet<Set> set= new TreeSet<>((i, j)-> (i.node.val== j.node.val? i.index- j.index: i.node.val- j.node.val));
        for(Set i: list) if(i.node!= null) set.add(i);
        
        ListNode head= null, ans= null;
        while(!set.isEmpty()) {
            Set curr_set= set.pollFirst();
            ListNode curr= curr_set.node;
            int index= curr_set.index;
            
            if(head== null) { 
                head= curr; 
                if(curr.next!= null) set.add(new Set(curr.next, index)); 
                ans= head;
                continue; 
            } else {
                head.next= curr;
                if(curr.next!= null) set.add(new Set(curr.next, index));
                head= head.next;
            }
        }
        
        return ans;
    }
}
