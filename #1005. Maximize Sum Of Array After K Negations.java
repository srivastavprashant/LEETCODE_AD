//1005. Maximize Sum Of Array After K Negations


class Solution {
    public int largestSumAfterKNegations(int[] A, int k) 
    {
        PriorityQueue<Integer> q= new PriorityQueue<>();
        int sum=0;
        
        for(int i: A)
        { q.add(i); sum+=i; }
        
        while(k!=0)
        {
            int val= q.poll();
            sum= sum -val +(val*-1);
            q.add(val*-1);
            k--;
        }
        
        return sum;
    }
}
