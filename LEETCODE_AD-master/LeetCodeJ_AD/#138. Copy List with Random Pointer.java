package LeetCodeJ;// #138. Copy List with Random Pointer

class Solution {
    public Node copyRandomList(Node head) {
        if(head== null) return null;
        Node temp= head;
        while(temp!= null) {
            Node copy= new Node(temp.val);
            copy.random= temp.random;
            copy.next= temp.next;
            temp.next= copy;
            temp= temp.next.next;
        }
        
        temp= head.next;
        while(temp!= null) {
            if(temp.random!= null) temp.random= temp.random.next;
            if(temp.next== null) break;
            temp= temp.next.next;
        }
        
        temp= head;
        Node ret= head.next, save= head.next;
        while(temp!= null) {
            if(temp.next!= null) temp.next= temp.next.next;
            if(ret.next!= null) ret.next= ret.next.next;
            temp= temp.next;
            ret= ret.next;
        }
        
        return save;
    }
    
    void debug(Node head) {
        Node temp= head;
        while(temp!= null) {
            System.out.print(temp.val+" ");
            temp= temp.next;
        }
        System.out.println();
    }
}
