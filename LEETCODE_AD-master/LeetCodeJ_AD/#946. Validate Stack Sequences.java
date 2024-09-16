package LeetCodeJ;//946. Validate Stack Sequences

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) 
    {
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        int pop=0, push=0;
        
        while(pop!=popped.length)
        {
            while(push!= pushed.length && stack.peek()!= popped[pop])
                stack.push(pushed[push++]);
            
            if(stack.peek()!= popped[pop])
                return false;
            
            stack.pop();
            pop++;
        }
        System.out.println(pop);
        
        return pop== popped.length;
    }
}
