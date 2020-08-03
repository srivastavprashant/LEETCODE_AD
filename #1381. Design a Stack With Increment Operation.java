// #1381. Design a Stack With Increment Operation

// Naive Approach
class CustomStack 
{
    int maxSize;
    Stack<Integer> stack;
    
    public CustomStack(int maxSize) 
    {
        this.maxSize= maxSize;
        stack= new Stack<>();
    }
    
    public void push(int x) 
    {
        if(stack.size()<maxSize)
        {
            stack.push(x);
        }
    }
    
    public int pop() 
    {
        if(stack.size()==0)
            return -1;
        
        return stack.pop();   
    }
    
    public void increment(int k, int val) 
    {
        Stack<Integer> temp= new Stack<>();
        
        while(!stack.isEmpty())
            temp.push(stack.pop());
        
        int i=1;
        while(!temp.isEmpty())
            stack.push(temp.pop()+(i++<=k? val: 0));
    }
}

// Efficient approach
class CustomStack 
{
    int maxSize;
    Stack<Integer> stack;
    int[] map;
    
    public CustomStack(int maxSize) 
    {
        this.maxSize= maxSize;
        stack= new Stack<>();
        map=new int[maxSize+1];
    }
    
    public void push(int x) 
    {
        if(stack.size()<maxSize)
        {
            map[stack.size()+1]=0;
            stack.push(x);
        }
    }
    
    public int pop() 
    {
        if(stack.size()==0)
            return -1;
    
        int i= stack.size();
        map[i-1]+= map[i];
        return stack.pop()+ map[i];   
    }
    
    public void increment(int k, int val) 
    {
        k= Math.min(k, stack.size());
        map[k]+= val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
