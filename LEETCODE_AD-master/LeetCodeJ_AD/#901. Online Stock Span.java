package LeetCodeJ;// 901. Online Stock Span

class StockSpanner {
    Stack<Integer[]> stack;
    
    public StockSpanner() {
        stack= new Stack<>();
    }
    
    public int next(int price) {
        int ret=1;
        
        while(!stack.isEmpty() && stack.peek()[1]<= price)
        { Integer[] curr=stack.pop(); ret+= curr[0]; }
        
        stack.push(new Integer[]{ret, price});
        return ret;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
