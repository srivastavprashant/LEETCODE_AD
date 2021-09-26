// #146. LRU Cache



class LRUCache {
    class Node {
        Node prev, next;
        int key, val;
        Node (int key, int val, Node next, Node prev) {
            this.key= key;
            this.prev= prev;
            this.next= next;
            this.val= val;
        }
    }
    
    Node head, tail;
    Map<Integer, Node> map;
    int MAX_SIZE;

    public LRUCache(int capacity) {
        MAX_SIZE= capacity;
        head= tail= null;
        map= new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        else {
            Node curr= map.get(key);
            if(curr== tail) return curr.val;
            if(curr.prev!= null) curr.prev.next= curr.next;
            else head= curr.next;
            
            curr.next.prev= curr.prev; 
            
            tail.next= curr;
            curr.prev= tail;
            curr.next= null;
            tail= curr;
            return curr.val;
        }
    }
    
    public void put(int key, int value) {
        // System.out.println("for: "+key);
        // debug();
        if(map.containsKey(key)) {
            Node curr= map.get(key);
            curr.val= value;
            if(curr== tail) return;
            
            if(curr.prev!= null) curr.prev.next= curr.next;
            else head= curr.next;
            curr.next.prev= curr.prev;
            
            tail.next= curr;
            curr.prev= tail;
            curr.next= null;
            tail= curr;
        } else {
            if(map.size()== MAX_SIZE) { 
                map.remove(head.key);
                head= head.next; 
                if(head!= null)
                head.prev= null; 
            }
            
            if(head== null) {
                Node temp= new Node(key, value, null, null);
                // temp.prev.next= temp;
                head= tail= temp;
                map.put(key, temp);
            } else {
                Node temp= new Node(key, value, null, tail);
                temp.prev.next= temp;
                tail= temp;
                map.put(key, temp);
            }
        }
        // debug();
    }
    
    void debug() {
        Node temp= head;
        while(temp!= null) {
            System.out.print("["+temp.key+", "+temp.val+"], ");
            temp= temp.next;
        }
        
        System.out.println();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
