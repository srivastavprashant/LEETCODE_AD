package LeetCodeJ;// #1670. Design Front Middle Back Queue


class FrontMiddleBackQueue 
{
    Deque<Integer> q;
    int len=0;
    public FrontMiddleBackQueue() {
        q= new LinkedList<>();
    }
    
    public void pushFront(int val) {
        q.addFirst(val);
    }
    
    public void pushMiddle(int val) {
        int size= q.size();
        size= size/2;
        
        Stack<Integer> stack= new Stack<>();
        while(size!=0)
        {
            stack.add(q.pollFirst());
            size--;
        }
        
        q.addFirst(val);
        while(!stack.isEmpty())
            q.addFirst(stack.pop());
    }
    
    public void pushBack(int val) {
        q.addLast(val);
    }
    
    public int popFront() {
        if(q.size()==0)
            return -1;
        return q.pollFirst();
    }
    
    public int popMiddle() {
        if(q.size()==0)
            return -1;
        
        int size= q.size();
        int pop=0, ret=0;
        
        Stack<Integer> stack= new Stack<>();
        while(pop!= size/2)
        {
            stack.push(q.pollFirst());
            pop++;
        }
        
        if(size%2==0)
            ret= stack.pop();
        else
            ret= q.pollFirst();
        
        while(!stack.isEmpty())
            q.addFirst(stack.pop());
        
        return ret;
    }
    
    public int popBack() {
        if(q.size()==0)
            return -1;
        return q.pollLast();
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
