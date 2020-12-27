#117. Populating Next Right Pointers in Each Node II


class Solution 
{
    void call(Node root)
    {
        if(root== null) return;
        
        Node temp= root.next;
        while(temp!=null && (temp.left== null && temp.right== null))
        { temp= temp.next; }
        
        if(root.left!= null)
        {
            if(root.right!= null)
                root.left.next= root.right;
            else
                root.left.next= (temp== null? null: temp.left!=null? temp.left: temp.right);
        }
        
        if(root.right!= null)
            root.right.next= (temp== null? null: temp.left!=null? temp.left: temp.right);
        
        call(root.right);
        call(root.left);
    }
    public Node connect(Node root) 
    {
        call(root);
        
        return root;
    }
}
