// #1856. Maximum Subarray Min-Product


class Solution {
    public int maxSumMinProduct(int[] nums) {
        int[] left= new int[nums.length];
        int[] right= new int[nums.length];
        left(nums, left);
        right(nums, right);
        
        long[] prefix= new long[nums.length];
        for(int i=0;i<nums.length;i++) prefix[i]= (i!=0? prefix[i-1]: 0)+ nums[i];
        
        long max= 0l;
        for(int i=0;i<nums.length;i++) {
            int l= left[i];
            int r= right[i];
            
            max= Math.max(max, nums[i]* (prefix[r-1]- (l!= -1? prefix[l]: 0)));
        }
        
        return (int)(max%1000000007);
    }
    
    private void left(int[] nums, int[] left) {
        Stack<Integer> stack= new Stack<>();
        
        for(int i=0;i<nums.length;i++) {
            while(!stack.isEmpty() && nums[stack.peek()]>= nums[i]) stack.pop();
            
            left[i]= stack.isEmpty()? -1: stack.peek();
            stack.push(i);
        }
    }
    
    private void right(int[] nums, int[] right) {
        Stack<Integer> stack= new Stack<>();
        
        for(int i= nums.length-1;i>= 0; i--) {
            while(!stack.isEmpty() && nums[stack.peek()]>= nums[i]) stack.pop();
            
            right[i]= stack.isEmpty()? nums.length: stack.peek();
            stack.push(i);
        }
    }
}
