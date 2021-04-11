// #1823. Find the Winner of the Circular Game

class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> arr= new ArrayList<>();
        for(int i=1;i<= n;i++) arr.add(i);
        
        int count= 0, curr= 0;
        while(count!= n-1) {
            int iter= 0;
            while(iter!= k) { if(arr.get(curr%n)!= -1) {iter++;} curr++; }
            
            arr.set(--curr%n, -1);
            count++;
        }
        
        for(int i: arr)
            if(i!= -1) return i;
        return 0;
    }
}
