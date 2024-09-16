package LeetCodeJ;// #707. Design Linked List



class MyLinkedList {
    class Node {
        Node next;
        int val;
        Node (int val, Node next) {
            this.val= val;
            this.next= next;
        }
    }
    Map<Integer, Node> map;
    Node head;
    public MyLinkedList() {
        map= new HashMap<>();
        head= null;
    }
    
    public int get(int index) {
        int i= 0;
        Node temp= head;
        while(temp!= null) {
            if(i== index) break;
            temp= temp.next;
            i++;
        }
        
        if(i!= index || temp== null) return -1;
        else return temp.val;
    }
    
    public void addAtHead(int val) {
        Node temp= new Node(val, null);
        if(head== null) { head= temp; }
        else { temp.next= head; head= temp; }
    }
    
    public void addAtTail(int val) {
        Node temp= new Node (val, null);
        if(head== null) { head= temp; return; }
        Node root= head;
        while(root.next!= null) root= root.next;
        root.next= temp;
    }
    
    public void addAtIndex(int index, int val) {
        if(index== 0) { addAtHead(val); return; }
        int i= 0;
        Node temp= head;
        while(temp!= null) {
            if(i== index-1) break;
            temp= temp.next;
            i++;
        }
        
        if(temp== null) return;
        if(temp.next== null) { addAtTail(val); return; }
        
        if(i== index-1) {
            Node temp_new= new Node(val, null);
            Node save= temp.next;
            temp.next= temp_new;
            temp_new.next= save;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index== 0) { head= head.next; return; }
        int i= 0;
        Node temp= head;
        while(temp!= null) {
            if(i== index-1) break;
            temp= temp.next;
            i++;
        }
        
        if(temp!= null && i== index-1 && temp.next!= null) {
            temp.next= temp.next.next;
        }
    }
}
