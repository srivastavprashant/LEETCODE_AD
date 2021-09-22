// #622. Design Circular Queue

class MyCircularQueue {
    class ListNode {
        ListNode next;
        int val;
        ListNode(int val, ListNode next) {
            this.val= val;
            this.next= next;
        }
    }

    int size;
    int MAX_SIZE;
    ListNode head, tail;
    public MyCircularQueue(int k) {
        MAX_SIZE= k;
        size= 0;
        head= tail= null;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        else {
            if(head== null) {
                head= tail= new ListNode(value, null);
            } else {
                tail.next= new ListNode(value, null);
                tail= tail.next;;
            }
            
            size++;
            return true;
        }
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        else {
            head= head.next;
            size--;
            return true;
        }
    }
    
    public int Front() {
        return head== null? -1: head.val;
    }
    
    public int Rear() {
        return head== null? -1: tail.val;
    }
    
    public boolean isEmpty() {
        return size== 0;
    }
    
    public boolean isFull() {
        return MAX_SIZE== size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
