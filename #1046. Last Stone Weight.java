// 1046. Last Stone Weight


class Solution {
    public int lastStoneWeight(int[] stones) 
    {
        PriorityQueue<Integer> q= new PriorityQueue<>(new Comparator<Integer>()
            {
                public int compare(Integer a, Integer b)
                {
                    return b-a;
                }
            });
        
        for(int i: stones)
            q.add(i);
        
        while(q.size()>1)
        {
            int a= q.poll();
            int b= q.poll();
            
            q.add(Math.abs(a-b));            
        }
        
        return q.poll();
    }
}
