/*
    (Stacks)
    
    Intuition: We need two index lets say i and j, that we need to swap where i<j.
               i will be the first element (backward traversal) which will be greater than its previous encountered values.
               Where as j will be the first element(backward traversal) thats smaller than arr[i], and j need to store the smallest index (till where the array is traversed)
               of that value 
    
    Algorithm: 1. Push into stack until current index element is smaller or equal to the element at stack top. 
               2. While pushing elements elimate special cases of repeated elements push only the most recent encounter.
               3. pop until stack top is smaller.
               4. swap them
*/
class Solution {
    public int[] prevPermOpt1(int[] arr) 
    {
        Stack<Integer> stack=new Stack<>();
        int i;
        
        for(i=arr.length-1;i>=0;i--)
            if(!stack.isEmpty() && arr[stack.peek()]==arr[i])
            {
                stack.pop();
                stack.push(i);
            }
            else if(stack.isEmpty() || arr[stack.peek()]>arr[i])
                stack.push(i);
            else
                break;
        //System.out.println(stack);
        if(i<0)
            return arr;
        
        int index=0;
        
        while(!stack.isEmpty() && arr[stack.peek()]<arr[i])
            index= stack.pop();
        
        int swap= arr[index];
        arr[index]= arr[i];
        arr[i]= swap;
        
        return arr;
    }
}
